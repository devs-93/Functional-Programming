package lecture.functionalprogramming

case object HighOpsCurries extends App {

  //  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
  // higher order function (HOF)
  // map, filter , flatMap these all are Higher order function


  /** ********************************************************
   * ********** HighOpsCurries Function Application Example***
   * ******************************************************** */
  //nTimes(f,n,x)
  //nTimes(f,3,x)   =>>   f(f(f(x)))  =>>> nTimes(f,3,f(x))   =>> nTimes(f,2,f(x))  ==>> =>> nTimes(f,1,f(x))
  val plusTen = ((x: Int) => x + 1)

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) {
      x
    }
    else {
      nTimes(f, (n - 1), f(x))
    }
  }

  val resultDataOne: Int = nTimes(plusTen, 2, 5)
  println("Result : " + resultDataOne)


  val stringToCapitalStringTwoTimes = {
    (dataValue: String) => ((dataValue.toUpperCase) * 2)
  }

  def nTimesStringConcatenation(f: String => String, n: Int, value: String): String = {
    if (n <= 0)
      value
    else {
      nTimesStringConcatenation(f, (n - 1), f(value))
    }
  }

  val resultDataTwo: String = nTimesStringConcatenation(stringToCapitalStringTwoTimes, 2, "INDIA")
  println(resultDataTwo)


  /** ************************************************************************
   * ********** HighOpsCurries Function Application Example(Better Approach)***
   * ************************************************************************ */
  //ntb(f,n) = x => f(f(f(x)))
  //increment3 = ntb(plusOne,3)     =        [ x => plusOne(plusOne(plusOne(x))) ]
  //
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) {
      (x: Int) => x
    }
    else {
      (x: Int) => (nTimesBetter(f, n - 1)(f(x)))
    }
  }

  val plus1 = (x: Int) => (x + 1)
  val functionBetter = nTimesBetter(plus1, 10)
  println("functionBetter : " + functionBetter(1))


  val plusFunction = ((x: Int) => x + 1)
  val threeTimesFuncNeedToApply = nTimesBetter(plusFunction, 1)
  println(threeTimesFuncNeedToApply(1))


  //curried function
  val superAdder: Int => (Int => Int) = (x: Int) => ((y: Int) => x + y)
  val add3 = superAdder(3) //y => 3+y
  println(add3(10))
  println(superAdder(10)(100))


  //function with multiple parameter list
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat1: (Double => String) = curriedFormatter("%4.4f")
  val standardFormat2: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat1(Math.PI))
  println(standardFormat2(Math.PI))

  //  println("====================> Now (Small Exercise) <======================")
  /*
  1. toCurry(f:(Int,Int)=> Int )   =>  (Int=>Int=>Int)
  2. fromCurry(f:(Int=>Int=>Int))  =>  (Int,Int)=> Int
  3. compose(f,g) => x => f(g(x))
  4. andThen(f,g) => x => g(f(x))
  */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = {
    x => y => f(x, y)
  }

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = {
    (x, y) => f(x)(y)
  }

  def compose(f: Int => Int, g: Int => Int): (Int => Int) = {
    x => f(g(x))
  }

  def composeGen[A, B, T](f: A => B, g: T => A): (T => B) = {
    x => f(g(x))
  }

  def andThen(f: Int => Int, g: Int => Int): (Int => Int) = {
    x => g(f(x))
  }

  def andThenGen[A, B, C](f: A => B, g: B => C): (A => C) = {
    x => g(f(x))
  }


  def superAdder2: (Int => Int => Int) = toCurry(_ + _)

  println(superAdder2(2)(10))

  def simpleAdder = fromCurry(superAdder)

  println(simpleAdder(2, 10))


  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composedCall=compose(add2,times3)
  val orderedCall=andThen(add2,times3)
  println(composedCall(10))
  println(orderedCall(10))
}
