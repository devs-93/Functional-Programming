package lecture.patternmatching

import scala.util.Random

object PatternMatching extends App {

  val random = new Random()
  val x = random.nextInt(10)
  //PatternMatching (This is called PatternMatching)
  val description = x match {
    case 1 => "ONE"
    case 2 => "TWO"
    case 3 => "THREE"
    case 4 => "FOUR"
    case 5 => "FIVE"
    case _ => "OTHER NO" // WILDCARD LATER(DEFAULT CASE)
  }
  println(x)
  println(description)
  println()

  //Decompose of instance value using patter PatternMatching
  case class Person(name: String, age: Int)

  val person = new Person("Bob", age = 29)
  val greeting = person match {
    case Person(name, age) => s"my name is $name and I am $age year old !!"
    case _ => "other object found unable to decompose"
  }
  println(greeting)


  //Decompose of instance value using patter PatternMatching with [Gard(like a where  condition)]
  val greetingNew = person match {
    case Person(name, age) if (age < 10) => s"my name is $name and I am $age year old !!"
    case _ => "other object found unable to decompose"
    case Person(name, age) => s"my name is $name and I am $age year old !!"
  }
  println(greetingNew)


  /*
  1. cases are matched in order
  2. what is no cases match ? MatchError
  3. type of the PM expression ? unified type of all the types in all the cases.
  4. PM works well with case classes.
  */


  // PM on sealed hierarchy
  sealed class Animal

  case class Dog(bread: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Tommy")

  animal match {
    case Dog(s) => println(s"Dog is $s")
  }


  // match everything
  val isEven = x match {
    case num if num % 2 == 0 => true
    case _ => false
  }
  println(isEven)

  //WHY ??
  val isEvenCond = if (x % 2 == 0) true else false
  val isEvenNormal = x % 2 == 0

  /*
  Exercise
  (1). simple function uses PM
  (2). take expression as input and return human readable output
  */
  trait Expression

  case class Number(n: Int) extends Expression

  case class Sum(e1: Expression, e2: Expression) extends Expression

  case class Prod(e1: Expression, e2: Expression) extends Expression


  def show(e: Expression): String = {
    e match {
      case Number(n) => s"$n"
      case Sum(e1, e2) => show(e1) + " + " + show(e2)
      case Prod(e1, e2) => {
        def maybeShowParenthesis(expression: Expression) = expression match {
          case Prod(_, _) => show(expression)
          case Number(_) => show(expression)
          case _ => "(" + show(expression) + ")"
        }

        maybeShowParenthesis(e1) + " * " + maybeShowParenthesis(e2)
      }
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(10))))
  println(show(Prod(Sum(Number(2), Number(3)), Number(10))))
  println(show(Sum(Prod(Number(100), Number(200)), Number(200))))

}
