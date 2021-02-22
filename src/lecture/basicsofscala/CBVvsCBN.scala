package lecture.basicsofscala

object CBVvsCBN extends App {
  def calledByValue(x: Long): Unit = {
    println("The Value 1:" + x)
    println("The Value 2:" + x)
    println("The Value 3:" + x)
  }


  def calledByName(x: => Long): Unit = {
    println("The Name 1:" + x)
    println("The Name 2:" + x)
    println("The Name 3:" + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())


  def infinite(): Int = {
    1 + infinite()
  }

  def printFirst(x: Int, y: => Int): Unit = {
    println(x)
  }

  printFirst(34, infinite())

}
