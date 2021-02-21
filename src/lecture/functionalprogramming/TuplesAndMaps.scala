package lecture.functionalprogramming

import sun.plugin2.main.client.DisconnectedExecutionContext

object TuplesAndMaps extends App {
  //  tuple = finite order "lists"
  val aTuple = new Tuple2(2, "Hello") // tuple2 with int and string Tuple2[Int,String]=(Int,String)
  //  OR
  val bTuple = Tuple2(2, "Hello")
  //  OR
  val cTuple = (2, "Hello")
  println(aTuple)

  /*
  Important Note
  Tuple can be grouped with at most 22 different data types
  */

  println(aTuple._1)
  println(aTuple._2)
  println(aTuple.copy(_1 = 100, _2 = "Good Bye !! Friend"))
  println(aTuple.swap)

  //  Maps - (keys -> values)
  val aMap: Map[String, Int] = Map()
  val phonebook = Map(("JIM", 555), ("Shukla", 501), "jim" -> 1001).withDefaultValue("No value is found for the key")
  //  syntactic sugar is a->b for tuple (a,b)
  println(phonebook)

  println()
  //  Maps Operation in scala
  println(phonebook.contains("Shukla"))
  println(phonebook.apply("JIM"))
  println(phonebook("jim"))

  println(phonebook("Marry")) //key not found: Marry (ERROR)


  //  add a pairing
  val newPairing = "Mary" -> 101
  val newPhonebook = phonebook + newPairing
  println(newPhonebook) //map is immutable


  println()
  //  functions on maps
  //  map,flatmap,filter
  println("toLowerCase---------->", phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  //  filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")))
  println(phonebook.values)
  println()
  //  mapValues
  println(phonebook.mapValues(x => "0245-" + x))

  println()

  //  conversion to other collection
  println(phonebook.toList)
  println(List(("JIM", 555), ("Shukla", 501), ("jim", 1001)).toMap)

  println()

  val names = List("Rahul", "Raju", "Shiv", "Rohit", "Shukla", "Johan", "son")
  println(names.groupBy(x => x.charAt(0)))


  //  1. what would happened if I had two original entries "JIM"->555 and "jim"->1001
  //  Ans:-   !! careful with mapping keys
  println("")
  (1 to 3).foreach(x => println("#########################################################################"))


  // 2. add a person to the network
  def add_A_Person(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }


  // 3. friends (mutual friends)
  def friendsOfEachOther(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsOfA = network(a)
    val friendsOfB = network(b)
    network + (a -> (friendsOfA + b)) + (b -> (friendsOfB + a))
  }


  // 4. unfriend (mutual friend)
  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsOfA = network(a)
    val friendsOfB = network(b)
    network + (a -> (friendsOfA - b)) + (b -> (friendsOfB - a))
  }



  // 5. remove person from network
  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) {
        networkAcc
      }
      else {
        removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
      }
    }

    val unfriended = removeAux(network(person), network)
    unfriended - person // removed key from the map directly
  }


  val empty: Map[String, Set[String]] = Map()
  val network = add_A_Person(add_A_Person(empty, "Marry"), "Bob")
  println(network)
  val net = friendsOfEachOther(network, "Bob", "Marry")
  println(net)
  println(unfriend(net, "Bob", "Marry"))
  println(remove(friendsOfEachOther(network, "Bob", "Marry"), "Bob"))


  //Jim,Bob,Mary
  println("")
  (1 to 1).foreach(x => println("#########################################################################################"))
  (1 to 1).foreach(x => println("########################Network-Demo(Jim,Bob,Mary)#######################################"))
  (1 to 1).foreach(x => println("#########################################################################################"))


  val people = add_A_Person(add_A_Person(add_A_Person(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friendsOfEachOther(people, "Bob", "Jim")
  println(jimBob)
  val testNet = friendsOfEachOther(jimBob, "Bob", "Mary")
  println(testNet)


  def nFriends(network: Map[String, Set[String]], person: String): Int = {
    if (!network.contains(person)) {
      0
    }
    else {
      (network(person).size)
    }
  }

  println(nFriends(testNet, "Jim"))
  println(nFriends(testNet, "Bob"))


  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  println(mostFriends(testNet))


  def nPeopleNoFriends(network: Map[String, Set[String]]): Int = {
    network.filterKeys(k => network(k).isEmpty).size
  }

  println(nPeopleNoFriends(testNet))

  println("")
  (1 to 1).foreach(x => println("#########################################################################################"))
  (1 to 1).foreach(x => println("########################Social-Connection################################################"))
  (1 to 1).foreach(x => println("#########################################################################################"))


  def socialConnection(network: Map[String, Set[String]], aLooksTarget: String, Target: String): Boolean = {

    def bfs(target: String, TillNowConsideredPeople: Set[String], YetToDiscoveredPeopleSet: Set[String]): Boolean = {
      if (YetToDiscoveredPeopleSet.isEmpty) {
        false
      }
      else {
        val person = YetToDiscoveredPeopleSet.head
        if (person == target) {
          true
        }
        else if (TillNowConsideredPeople.contains(person)) {
          bfs(target, TillNowConsideredPeople, YetToDiscoveredPeopleSet.tail)
        }
        else {
          bfs(target, TillNowConsideredPeople + person, YetToDiscoveredPeopleSet.tail ++ network(person))
        }
      }


    }

    bfs(Target, TillNowConsideredPeople = Set(), YetToDiscoveredPeopleSet = network(aLooksTarget) + aLooksTarget)
  }

  println(socialConnection(testNet, "Mary", "Jim"))

}
