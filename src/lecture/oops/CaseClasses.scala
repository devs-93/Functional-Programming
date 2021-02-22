package lecture.oops

object CaseClasses extends App {

  /*
  equals,hashcode,toString
  */

  case class Person(name: String, age: Int)

  //1.class parameter are fields now.
  val jim = new Person("Jim", age = 100)
  println("class parameter are fields now due to case class : ")
  println(jim.name)
  println(jim.age)


  //2. sensible toString method in case class
  //println(jim.toString) == println(jim) == Person("Jim", age = 100) [syntactical sugar]
  println(jim.toString)
  println(jim)


  //3. equals and hashcode
  val jim2 = new Person("Jim", age = 100)
  println(jim2 == jim)


  //4. case class copy handy method
  println("create new instance with same filed :")
  val jim3 = jim.copy()
  println(jim == jim2)
  println(jim2 == jim3)


  //5. case class have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. case classes are serializable
  // very helpful while working with  distributed system

  // 7. case classes have extractor pattern == case classes can be used in pattern matching

  // 8. Everything is same as Case class except they have not object class because it is by self object
  case object UnitedKingdom {
    def name: String = "Wow"
  }

  /*
  */


}
