package exercises

abstract class MyList {
  def head: Int
  def tail : MyList
  def isEmpty: Boolean
  def add(n:Int): MyList
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail : MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(n:Int): MyList = new Cons(n, Empty)
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail : MyList = t
  def isEmpty: Boolean = false
  def add(n:Int): MyList = new Cons(n, this)
}

object TestList extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.tail)

}