package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat
  }

  val anynomousAnimal : Animal = new Animal {
    override def eat: Unit = ???
  }

  trait MyPredicate[-T] {
    def test(element:T): Boolean
  }

  trait MyTransformer[-A,B] {
    def transform(element: A): B
  }

  abstract class MyList[+A] {
    def head: A
    def tail : MyList[A]
    def isEmpty: Boolean
    def add[B >: A](n:B): MyList[B]
    def map[B](transformer: MyTransformer[A,B]): MyList[B]
    def filter(predicate: MyPredicate[A]): MyList[A]
    def printElements: String

    override def toString : String = s"[$printElements]"
    def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B]
    def ++[B>:A](list:MyList[B]): MyList[B]
  }

  object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail : MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B>:Nothing](n:B): MyList[B] = new Cons(n, Empty)

    def map[B](transformer: MyTransformer[Nothing, B]) = Empty

    def filter(predicate: MyPredicate[Nothing]) = Empty
    def printElements: String = ""
    def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]) = Empty

    def ++[B >: Nothing](list: MyList[B]):MyList[B] = list
  }

  var listOfIntegerss:MyList[Int] = Empty
  var listOfStringss:MyList[String] = Empty

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h
    def tail : MyList[A] = t
    def isEmpty: Boolean = false
    def add[B>:A](n:B): MyList[B] = new Cons(n, this)

    def printElements:String = {
      if (t.isEmpty) "" + h
      else h + " " + t.printElements
    }

    def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
      new Cons(transformer.transform(h), t.map(transformer))
    }

    def filter(predicate: MyPredicate[A]) : MyList[A] = {
      if (predicate.test(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)

    }

    def ++[B>:A](list:MyList[B]): MyList[B] = new Cons(h, t ++ list)

    def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B]= {
      transformer.transform(h) ++ t.flatMap(transformer)
    }
  }

  val listOfIntegers1: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listOfIntegers1.map(new MyTransformer[Int, Int] {
    override def transform(element: Int) : Int = {
      element * 2
    }
  }).toString)

  println(listOfIntegers1.filter(new MyPredicate[Int] {
    override def test(element: Int) : Boolean = {
      element % 2 == 0
    }
  }))

  println(listOfIntegers1.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = {
      new Cons(element, new Cons(element + 1, Empty))
    }
  }))


}
