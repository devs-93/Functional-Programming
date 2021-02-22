package lecture.oops

object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = {
      movie == this.favoriteMovie
    }

    def hangOutWith(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }

    def +(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }


    def +(nickname: String): Person = new Person(s"${name} ($nickname)", favoriteMovie)


    def unary_+ : Person = {
      new Person(name, favoriteMovie, age + 1)
    }


    def isAlive: Boolean = {
      true
    }

    def apply(): String = {
      "I am apply method !! wow without () I can be used"
    }

    def apply(n: Int): String = {
      s"${this.name} watched $favoriteMovie $n times and you ?"
    }


    def learns(things: String): String = {
      s"${this.name} is learning ${things} !!"
    }

    def learnScala(): String = {
      this learns ("Scala")
      this learns "Scala"
    }
  }


  //operator in scala

  val mary = new Person("Mary", "Inception")
  //  println(mary.likes("inception")) //Normal Calling
  //  println(mary likes "inception") //infix notation (syntactic sugar)
  //  scala is more like to natural language just because of its syntactic sugar approach(infix notation)

  val tom = new Person("Tom", "Inception")

  println(mary.hangOutWith(tom))
  println(mary hangOutWith tom)

  //Using Operator Symbol
  println("Using Operator Symbol!!")
  println(mary + tom)
  println(mary.+(tom))

  println(2.+(1))


  //ALL OPERATOR ARE METHODS
  //  scala is more like to natural language just because of its [syntactic sugar] approach(prefix notation)
  val x = -1 //equivalent with 1.unary_-
  val y = 1.unary_-
  val z = 1.unary_+
  val a = 1.unary_~

  println(+mary)
  println(mary.unary_+)

  //ALL OPERATOR ARE METHODS
  //  scala is more like to natural language just because of its [syntactic sugar] approach(postfix notation)
  println(mary.isAlive)
  println(mary isAlive)


  //apply method
  println(mary.apply())
  println(mary())

  /*
  Operator Overload
  * */

  println((mary + "the rockstar"))
  println((+mary).age)

  println(mary learnScala())
  println(mary.apply(10))
  println(mary(10))

}
