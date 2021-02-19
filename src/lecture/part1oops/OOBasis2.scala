package lecture.part1oops

object OOBasis2 extends App {
  val author = new Writer("Charles", "Shukla", 1993)
  val author1 = new Writer("Charles", "Shukla", 1993)
  val novel = new Novel("The Ramayana", 2019, author)
  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(author1))


  //this is normal call for incrementing or decrementing
//  val count = new Counter(0)
//  count.inc.print
//  count.inc.inc.inc.print
//  count.print

  //this is argument based call for incrementing and decrementing
  val countArg = new Counter(0)
  countArg.inc(4).print

}


class Writer(firstName: String, lastName: String, val dob: Int) {
  def fullName(): String = {
    firstName + " " + lastName
  }
}


class Novel(name: String, year: Int, author: Writer) {
  def authorAge(): Int = {
    year - author.dob
  }


  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(newYear: Int): Novel = {
    new Novel(this.name, newYear, this.author)
  }

}


class Counter(val count: Int) {
  def inc = {
    println("incrementing")
    new Counter(count + 1) //immutability
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  //  def inc(n: Int) = {
  //    new Counter(count + n)
  //  }
  //
  //  def dec(n: Int) = {
  //    new Counter(count - n)
  //  }

  def inc(n: Int): Counter = {
    if (n <= 0) {
      this
    }
    else {
      inc.inc(n - 1)
    }
  }

  def dec(n: Int): Counter = {
    if (n <= 0) {
      this
    }
    else {
      dec.dec(n - 1)
    }
  }

  def print = {
    println(count)
  }


}


