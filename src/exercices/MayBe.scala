package exercices

abstract class MayBe[+T] {
  def map[B](f: T => B): MayBe[B]

  def flatMap[B](f: T => MayBe[B]): MayBe[B]

  def filter(p: T => Boolean): MayBe[T]
}

case object MaybeNot extends MayBe[Nothing] {
  override def map[B](f: Nothing => B): MayBe[B] = MaybeNot

  override def flatMap[B](f: Nothing => MayBe[B]): MayBe[B] = MaybeNot

  override def filter(p: Nothing => Boolean): MayBe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends MayBe[T] {
  override def map[B](f: T => B): MayBe[B] = new Just[B](f(value))

  override def flatMap[B](f: T => MayBe[B]): MayBe[B] = f(value)

  override def filter(p: T => Boolean): MayBe[T] = {
    if (p(value)) {
      this
    }
    else {
      MaybeNot
    }
  }
}


object MayBeTest extends App {
  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(_ % 2 == 0))

}

