package lecture.part1oops

object AbstractDataTypes extends App {

  //Abstract class
  abstract class Animal {
    val creatureType: String //unimplemented methods/members
    def eat: Unit //unimplemented methods/members
    val preferredMealForAnimal = "South Indian"
  }

  //traits class
  trait Carnivore {
    def carnivoreEat(animal: Animal): Unit //unimplemented methods/members
    val preferredMealForCarnivore = "South Indian"
  }

  class Dog extends Animal with Carnivore {
    override val creatureType: String = "Dog is lovely Pet"

    override def carnivoreEat(animal: Animal): Unit = println("its carnivoreEat")

    override def eat: Unit = println("carnivore(मांसाहारी)")
  }


  val dog = new Dog()
  dog.eat

  // traits vs abstracts
  // 1 - traits do not have constructor parameter
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits would be the right choice when will talk about "behaviour" ex:- carnivore(मांसाहारी)
  // 4 - abstract would be the right choice when will talk about "Things"  ex:- Animal(जानवर)


}
