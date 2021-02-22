package lecture.oops

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }


  //Anonymous Class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("WOW!!")
  }


  //UNDER the hood Compiler Implementation
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("WOW!!, AnonymousClasses$$anon$1")
  }


  val funnyAnimal2 = new AnonymousClasses$$anon$1()
  println(funnyAnimal.getClass)
  println(funnyAnimal2.getClass)


  class Person(name: String) {
    def sayHi: Unit = println(s"Hi , my name is $name, how can I help you ?")
  }


  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi , my name is Jim , how can I help you ?")
  }


  /*
  [1,2,3].map(n* 2) =[2,3,6]
  [1,2,3,4].filter(n%2) =[2,4]
  [1,2,3].flatMap(n => [n,n+1])
  */





}
