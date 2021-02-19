package lecture.functionalprogramming

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  //map operation
  println("------->>>>map operation")
  println(list.map(_ + 1))
  println(list.map((_) * 2 + " is a number "))

  //filter operation
  println("------->>>>filter operation")
  println(list.filter(_ % 2 == 0))
  val evenList = list.filter(_ % 2 == 0)
  println(evenList.map((_) * 2 + " is a number "))


  //flatMap operation
  println("------->>>>flatMap operation")
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))


  /*
  print all combination between two lists
  */
  val number = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")
  //List("a1","a2","a3","a4")
  //iteration
  val com = number.flatMap(n => chars.flatMap(c => colors.map(col => "" + n + c + col)))
  println(com)


  /*
  foreach loops
  */
  list.foreach(println)


  /*
  To increase read ability we have for-comprehension(shorthand for the long list as per above)
  * */
  val forCombination = for {
    n <- number /*if n % 2 == 0*/
    c <- chars
    colour <- colors /*if colour == "black"*/
  } yield "" + n + c + colour
  println("forCombination->>>>>>>>>>>>>>>>>>>>", forCombination)
  println("withoutCombination->>>>>>>>>>>>>>>>", com)


  for {
    n <- number
  } println(n)
  number.foreach(println)


  val data = list.map {
    x => x * 2
  }
  println(data)
  //syntax overload

  /*
  1. MyList Support for comprehension?
     (1) map(f:A=>B) => MyList[B]
     (2) filter(f:A => Boolean) => MyList[A]
     (3) flatMap(f:A => MyList[b]) => MyList[B]

  2. A small collection of at most ONE element -Maybe[+T]
     - map,flatMap,filter
  */

}
