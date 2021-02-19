package lecture.functionalprogramming

object WhatsAFunction extends App {

  // DREAM : use function as a first class element
  // Problem : object oriented programming

  val StringToInt = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  val StringToMulInt = new Function1[String, Int] {
    override def apply(string: String): Int = (string.toInt) * (string.toInt) / 10
  }

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }


  // Function types Function2 [A,B,R] === (A,B) => R
  //ALL SCALA FUNCTION IS AN OBJECT

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  //Function1[Int,Function1[Int,Int]]
  val superAdder: (Int) => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(superAdder)
  println(adder3)
  println(adder3(4))
  println(superAdder.apply(3).apply(4))
  println(superAdder(3)(4)) // curried function in scala

  //
  //  println(StringToInt.apply("100"))
  //  println(StringToMulInt.apply("100"))
  //  println(adder.apply(10, 10))
  //  println(concatenator.apply("Hello ", " Scala"))
}
