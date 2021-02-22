package lecture.oops

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY "(static)"
  //cant receive parm
  //type + its only instance

  object Person {
    //object leve FUNCTIONALITY
    val EYES = 10

    def canFly(name: String): String = s"my name is ${name}"

    //factory method to build instance
    def apply(mother: Person, father: Person): Person = {
      println("we are creating instance for you !!")
      new Person("Bobbie")
    }
  }

  class Person(val name: String) {
    //instance leve FUNCTIONALITY
  }

  //COMPANIONS

  println(Person.EYES)
  println(Person.canFly("'Leo'"))

  //Scala object == SINGLETON INSTANCE == object is SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)


  val bobbie1 = Person.apply(mary, john)
  val bobbie2 = Person(mary, john)


  //scala Application

}
