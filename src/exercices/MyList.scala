package exercices

abstract class MyList[+A] {
  /*
  head = return first element of the list
  tail = remainder of the list
  isEmpty = return list status
  add(Int) = new list after add of the element in the list
  toString = a string representation of the list in string format
  */
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def addFromBegin[B >: A](element: B): MyList[B]

  def printElements: String

  //polymorphic call
  override def toString: String = "[" + printElements + "]"

  //  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  //  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  //high order functions
  //  def map[B](transformer: A => B): MyList[B]
  //  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  //  def filter(predicate: A => Boolean): MyList[A]


  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zipWithFunction: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B, A) => B): B


}

object EmptyLinkedList extends MyList[Nothing] {
  def head: Nothing = throw new NotImplementedError()

  def tail: MyList[Nothing] = throw new NotImplementedError()

  def isEmpty: Boolean = true

  def addFromBegin[B >: Nothing](element: B): MyList[B] = new Cons(element, EmptyLinkedList)

  override def printElements: String = ""


  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyLinkedList

  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = EmptyLinkedList

  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyLinkedList

  //high order functions
  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = EmptyLinkedList

  override def zipWith[B, C](list: MyList[B], zipWithFunction: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) {
      throw new RuntimeException("List is not same length")
    }
    else {
      EmptyLinkedList
    }
  }

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}


class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def addFromBegin[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + "," + t.printElements
  }


  //Filter
  //  override def filter(predicate: MyPredicate[A]): MyList[A] = {
  //    if (predicate.test(h)) {
  //      new Cons(h, t.filter(predicate))
  //    }
  //    else {
  //      t.filter(predicate)
  //    }
  //
  //  }

  //high order function
  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) {
        new Cons(x, EmptyLinkedList)
      }
      else if (compare(x, sortedList.head) <= 0) {
        new Cons(x, sortedList)
      }
      else {
        new Cons(sortedList.head, insert(x, sortedList.tail))
      }
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], zipWithFunction: (A, B) => C): MyList[C] = {
    if (list.isEmpty) {
      throw new RuntimeException("List is not same length")
    }
    else {
      new Cons(zipWithFunction(h, list.head), t.zipWith(list.tail, zipWithFunction))
    }
  }


  /*
  [1,2,3].fold(0)
   ns=(0+1)=1
   [2,3].fold(1)(+)

   ns=1+2=3
   [3].fold(3)(+)

   ns=3+3=6
   [].fold(6)(+)

   result=6


  */
  override def fold[B](start: B)(operator: (B, A) => B): B = {
    val newStart = operator(start, h)
    t.fold(newStart)(operator)
  }
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transformer(elem: A): B
}


object ListTest extends App {
  val singlyLinkedListInt: MyList[Int] = new Cons(100, new Cons(200, new Cons(300, new Cons(400, new Cons(500, EmptyLinkedList)))))
  val singlyLinkedListStr: MyList[String] = new Cons("E", new Cons("D", new Cons("C", new Cons("B", new Cons("A", EmptyLinkedList)))))

  println(singlyLinkedListInt.toString)
  //  println(singlyLinkedListStr.toString)

  println("====================> Now we are Expending MyList(Big Exercise) <======================")
  /*
  1. foreach method A=> Unit
     [1,2,3].foreach(x=>println(x))

  2. sort function ((A,A) => Int) => MyList
     [1,2,3].sort((x,y)=>y-x) => [3,2,1]

  3. zipWith (list , (A,A)=>B ) => MyList[B]
     [1,2,3].zipWith( [4,5,6] , (x*y) ) =>  [1*4,2*5,3*6] = [4,10,18]

  4. fold(start)(function) => a value
      [1,2,3].fold(0)(x+y) = 6
  */

  //  println("====================> Now (Small Exercise) <======================")
  /*
1. toCurry(f:(Int,Int)=> Int )   =>  (Int=>Int=>Int)
2. fromCurry(f:(Int=>Int=>Int))  =>  (Int,Int)=> Int
3. compose(f,g) => x => f(g(x))
4. andThen(f,g) => x => g(f(x))
*/

  singlyLinkedListInt.foreach(x => println(x))
  println(singlyLinkedListInt.sort((x, y) => y - x))
  println(singlyLinkedListInt.zipWith(singlyLinkedListStr, (x: Int, y: String) => x + "-" + y))
  val funMul = (x: Int, y: Int) => x + y
  println(singlyLinkedListInt.fold(2)(funMul))


  /*
  for comprehension
  */
  val combination = for {
    num <- List(1, 2, 3, 4, 5)
    str <- List("A", "B", "C")
  } yield num + "-" + str
  println(combination)

  //OR

  println(for {
    num <- List(1, 2, 3, 4, 5)
    str <- List("A", "B", "C")
  } yield num + "-" + str)
}



