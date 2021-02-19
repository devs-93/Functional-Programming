package lecture.functionalprogramming

import scala.util.Random

object Sequences extends App {

  //Seq
  val sequence = Seq(1, 4, 3, 2)
  println(sequence)
  println(sequence.reverse)
  println(sequence.apply(2)) //sequence.get(2)
  println(sequence ++ Seq(6, 7, 8, 9))
  println(sequence.sorted) //type is ordered

  //Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(x => println(x))


  //Ranges(non exclusive last number)
  val aRangeNew: Seq[Int] = 1 until 10
  aRangeNew.foreach(x => println(x))

  //Just printing like for loop
  (1 to 10).foreach(x => println("Hello"))


  //List
  val aList = List(1, 2, 3)
  val prepend = 42 :: aList
  //  val postponed =  aList :: 42 //not applicable
  println(prepend)
  //OR
  val prepended = 42 +: aList :+ 52
  println(prepended)

  //con list with num count and value
  val apple5 = List.fill(5)("Apple")
  println(apple5)

  println(aList.mkString((" # ")))

  //Arrays in scala
  val numbers = Array(1, 2, 3, 4)
  val threeNumbers = Array.ofDim[Int](3)
  threeNumbers.foreach(x => println(x))
  println()
  numbers.foreach(x => println(x))

  println()
  //mutation
  numbers(2) = 0 //syntax sugar numbers.updated(2,0)
  numbers.foreach(x => println(x))

  println()


  //Arrays and sequences
  val numberSeq: Seq[Int] = numbers //implicit conversion in scala
  println(numberSeq)

  // vectors
  val vector: Vector[Int] = Vector(1, 2, 3, 4)
  println(vector)
  println()

  //vector vs list
  val maxRuns = 1000
  val maxCap = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val startTime = System.nanoTime()
      //operation
      collection.updated(r.nextInt(maxCap), 100)
      System.nanoTime() - startTime
    }
    times.sum * 1.0 / maxRuns
  }

  // Adv:- keeps reference to tail
  // dis:- updating in middle of the list takes long time
  println("List   Update Time :", getWriteTime((1 to maxCap).toList) / 1000)
  println()
  // Adv :- depth of the tree is small
  // dis :- it needs to replace entre 32 element chunks
  println("Vector Update Time :", getWriteTime((1 to maxCap).toVector) / 1000)
}
