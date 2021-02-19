package exercices

abstract class MyListNew {
  /*
  head = return first element of the list
  tail = remainder of the list
  isEmpty = return list status
  add(Int) = new list after add of the element in the list
  toString = a string representation of the list in string format
  */
  def head: Int
  def tail: MyListNew
  def isEmpty: Boolean
  def addFromBegin(element: Int): MyListNew
  def printElements: String

  //polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object EmptyLinkedListNew extends MyListNew {
  def head: Int = throw new NotImplementedError()
  def tail: MyListNew = throw new NotImplementedError()
  def isEmpty: Boolean = true
  def addFromBegin(element: Int): MyListNew = new ConsNew(element, EmptyLinkedListNew)
  override def printElements: String = ""
}


class ConsNew(h: Int, t: MyListNew) extends MyListNew {
  def head: Int = h
  def tail: MyListNew = t
  def isEmpty: Boolean = false
  def addFromBegin(element: Int): MyListNew = new ConsNew(element, this)
  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTestNew extends App {
  val singlyLinkedList = new ConsNew(100, new ConsNew(200, new ConsNew(300, new ConsNew(400, new ConsNew(500, EmptyLinkedListNew)))))
  println(singlyLinkedList.head)
  println(singlyLinkedList.toString)
  val a = singlyLinkedList.addFromBegin(500)
  println(a.toString)
}



