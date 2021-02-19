package lecture.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  def bFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello a", 100))
  println(aFunction("Hello b", 500))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)


  def aRepeatedFunction(aString: String, aInt: Int): String = {
    if (aInt == 1) aString
    else aString + aRepeatedFunction(aString, aInt - 1)
  }

  println(aRepeatedFunction("Hello", 3))

  //WHEN YOU NEED LOOPS , USE RECURSION

  //a function with side effect
  def aFunctionWithSideEffect(aString: String): Unit = {
    println("This Function is Side effect Function !!")
  }

  println(aFunctionWithSideEffect("Side Effect Function"))

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(n1: Int, n2: Int): Int = {
      n1 * n2
    }

    aSmallFunction(n, n)
  }

  println(aBigFunction(10))


}

