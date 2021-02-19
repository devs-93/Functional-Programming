//package lecture.functionalprogramming
//
//object TuplesAndMaps extends App {
//  // tuple = finite order "lists"
//  val aTuple = new Tuple2(2, "Hello") // tuple2 with int and string Tuple2[Int,String]=(Int,String)
//  //OR
//  val bTuple = Tuple2(2, "Hello")
//  //OR
//  val cTuple = (2, "Hello")
//  println(aTuple)
//
//  /*
//  Important Note
//  Tuple can be grouped with at most 22 different data types
//  */
//
//  println(aTuple._1)
//  println(aTuple._2)
//  println(aTuple.copy(_1 = 100, _2 = "Good Bye !! Friend"))
//  println(aTuple.swap)
//
//  //Maps - (keys -> values)
//  val aMap: Map[String, Int] = Map()
//  val phonebook = Map(("JIM", 555), ("Shukla", 501), "jim" -> 1001).withDefaultValue("No value is found for the key")
//  // syntactic sugar is a->b for tuple (a,b)
//  println(phonebook)
//
//  println()
//  //Maps Operation in scala
//  println(phonebook.contains("Shukla"))
//  println(phonebook.apply("JIM"))
//  println(phonebook("jim"))
//
//  println(phonebook("Marry")) //key not found: Marry (ERROR)
//
//
//  //add a pairing
//  val newPairing = "Mary" -> 101
//  val newPhonebook = phonebook + newPairing
//  println(newPhonebook) // map is immutable
//
//
//  println()
//  //functions on maps
//  //map,flatmap,filter
//  println("toLowerCase---------->", phonebook.map(pair => pair._1.toLowerCase -> pair._2))
//
//  //filterKeys
//  println(phonebook.filterKeys(x => x.startsWith("J")))
//  println(phonebook.values)
//  println()
//  //mapValues
//  println(phonebook.mapValues(x => "0245-" + x))
//
//  println()
//
//  //conversion to other collection
//  println(phonebook.toList)
//  println(List(("JIM", 555), ("Shukla", 501), ("jim", 1001)).toMap)
//
//  println()
//
//  val names = List("Rahul", "Raju", "Shiv", "Rohit", "Shukla", "Johan", "son")
//  println(names.groupBy(x => x.charAt(0)))
//
//  //1. what would happened if I had two original entries "JIM"->555 and "jim"->1001
//  //Ans:-   !! careful with mapping keys
//
//  def add(network: Map[String, List[String]], person: String): Map[String, Set[String]] = {
//    network + (person -> Set())
//  }
//
//
//  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String,Set[String]] = {
//    val friendsA = network(a)
//    val friendsB = network(b)
//    network + (a -> (friendsA + b) + (b -> friendsB + a))
//  }
//
//  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
//    val friendsA = network(a)
//    val friendsB = network(b)
//    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
//  }
//
//
//}
