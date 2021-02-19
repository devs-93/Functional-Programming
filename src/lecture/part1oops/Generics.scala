package lecture.part1oops

object Generics extends App {


  class MyMap[key, values] {
    //USE THE TYPE key and values for process
  }

  val listOfIntegers = new MyList[Int]()
  val listOfStrings = new MyList[String]()


  object MyList {
    def empty[A]: MyList[A] = ???
  }

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???

    //USE THE TYPE A
  }

  val emptyListOfIntegers = MyList.empty[Int]


  // variance problem in Generics

  class Animal

  class Cat extends Animal

  class Dog extends Animal


  //if cat extends animal than list[cat] also extends list[Animals]
  // 1. YES, List[Cat] extends List[Animal] == COVARIANCE
  class CovariantList[+A]

  val animal: Animal = new Cat()
  val animalList: CovariantList[Animal] = new CovariantList[Cat]


  //animalList.add(new Dog) ??? HARD QUESTION
  // 2. NO == INVARIANCE
  class InvarianceList[A]
  //  val invarianceList: InvarianceList[Animal] = new InvarianceList[Cat]
  val invarianceList: InvarianceList[Animal] = new InvarianceList[Animal]


  // 3. Hell ,no!! Contravariance // we return list of animals
  class ContravarianceList[-A]
  val contravarianceList: ContravarianceList[Cat] = new ContravarianceList[Animal]
  // OR
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]


  // bounded types
  class Cage[A <: Animal](cageElement: A)

  val cageObj = new Cage(new Dog())

  class Human

  //can't use human object to pass in cage class it is restricted
  //  val cageHuman = new Cage(new Human())


  /*Expand myList collection to Generic */


}
