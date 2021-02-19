package lecture.part1oops

//Constructor
class Person(val name: String, val age: Int) {

  //body
  //function or methods
  //var or val
  //implementation
  val data = 100
  println("I am in side the class !!")


  //Method declaration and definition
  def greet(sString: String): Unit = {
    println(s"Hello all my self $sString and I am here to motivate to , how are you ${this.name} !!")
  }

  //Method Overloading
  def greet(): Unit = {
    println(s"Hi my Self $name")
  }

  //Multiple Constructor or overloading them
  def this(name: String) = this(name, 0)
  def this() = this("jOhn")
}


object OOBasics extends App {
  val person = new Person("jOHN", 26)
  println(person.age)
  println(person.name)
  println(person.data)
  person.greet()
  person.greet("Denial")


  //class parameter are not field till you will use val or var.


}


