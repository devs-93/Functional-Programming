package lecture.part1basics

object Practice extends App {

  // 1. print name and age
  def aFunction(name: String, age: Int): Unit = {
    println(s"Hi,my name is $name and my age is $age")
  }

  aFunction("Rahul", 29)

  def aFactorialFunction(n: Int): Int = {
    if (n == 0 || n == 1) 1
    else n * aFactorialFunction(n - 1)
  }

  println(aFactorialFunction(5))

  def aFibonacciFunction(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacciFunction(n - 1) + aFibonacciFunction(n - 2)
  }

  println(aFibonacciFunction(8))

}
