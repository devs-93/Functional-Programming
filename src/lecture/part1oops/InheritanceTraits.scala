package lecture.part1oops

object InheritanceTraits extends App {


  //Single class Inheritance
  class Animal {
    protected val creatureType = "International"

    def eat() = println("eat method in Animal")

    private def sleep() = println("this is sleep")

    protected def wakeup() = println("this is wakeup")
  }

  class Cat extends Animal {
    def cute() = {
      wakeup()
      println("cat is cut !!")
    }
  }

  val cat = new Cat()
  cat.cute()

  //  cat.sleep()



  //defining constructor in scala
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //Overriding
  class Dog extends Animal {
    override val creatureType: String = "Domestic"
    override def eat = {
      super.eat()
      println("eat method in Dog")
    }
  }

  val dog = new Dog()
  dog.eat()
  println(dog.creatureType)

  //Overriding(polymorphism)
  val unknownAnimal:Animal=new Dog()
  unknownAnimal.eat()


  //overRIDING vs overLOADING


  //super

  //preventing overrides
  // 1- use the keyword final on members.
  // 2- use the keyword final over class(this will prevent class to extends).
  // 3- seal the class
  // (you will use sealed keyword to do so , after doing this you can extends sealed class with in file but not out of the file)




}
