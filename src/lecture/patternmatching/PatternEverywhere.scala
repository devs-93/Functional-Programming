package lecture.patternmatching

object PatternEverywhere extends App {
  //big idea #1
  try {
    // code
  }
  catch {
    case e1: RuntimeException => "RuntimeException"
    case e2: NullPointerException => "NullPointerException"
    case _ => "Something Else"
  }
  // catches are actually matches
  /*
  try
  {//code}
  catch{
  e match {
    case e1: RuntimeException => "RuntimeException"
    case e2: NullPointerException => "NullPointerException"
    case _ => "Something Else"
  }
  */

  // big idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // something odd
  } yield {
    10 * x
  }

  // generator is also based on pattern matching
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (x, y) <- tuples
  } yield {
    x * y
  }
  //case classes, :: operators , ...


  // big idea #3
  val tuplesNew = (1, 2, 3)
  val (a, b, c) = tuplesNew
  println(a, b, c)


  //multiple value definition based on pattern matching
  //All the power is hear
  val head :: tail = list
  println(head + " -> and -> " + tail)

  // big Idea #4
  // partial function based on pattern of matching

  val mappedListOne = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  } //partial function literals

  val mappedListTwo = list.map { x => x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }

  println(mappedListOne)
  println(mappedListTwo)
}
