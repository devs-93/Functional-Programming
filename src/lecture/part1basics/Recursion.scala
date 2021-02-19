package lecture.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n == 0 || n == 1) {
      println("Completed factorial of " + n + " is " + n)
      1
    } else {
      println("Computing factorial of " + n + " but for this we need first factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Completed factorial of " + n + " is " + result)
      result
    }
  }

  @tailrec
  def factorialHelper(n: BigInt, acc: BigInt): BigInt = {

    if (n <= 1) {
      println("Till Calculated factorial is " + acc)
      acc
    }
    else {
      println("Till Calculated factorial is " + acc)
      factorialHelper(n - 1, n * acc)
    }
  }


  //  factorial(5000)
  println(factorialHelper(4, 1)) //TAIL RECURSIVE

  @tailrec
  def concatenateTailrec(aString: String, n: Int, acc: String): String = {
    if (n <= 0) acc
    else {
      concatenateTailrec(aString, n - 1, aString + acc)
    }
  }

  println(
    concatenateTailrec("Hello", 3, "")
  )
}
