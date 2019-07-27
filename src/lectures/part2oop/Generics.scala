package lectures.part2oop

import lectures.part2oop.Generics.MyAbstractList

object Generics extends App {

  class MyAbstractList[+A] {
  }

  object MyAbstractList
      def emptyAbstractList[A] : MyAbstractList[A] = ???


  class MyMap[Key,Value]


  var listOfIntegers = new MyAbstractList[Int]

  class LivingThing
  class Animal extends LivingThing
  class Dog extends Animal
  class Cat extends Animal

  class CovariantList[+A]{
//    def add [B >: A] (element: B): CovariantList[B] = ???
  }
  var covariantList: CovariantList[Dog] = new CovariantList[Dog]
//  covariantList.add(new Car)

  class InvariantLst

  class Cage[C <: Animal]
  class Car
  var c = new Cage[Cat]
  class Anything [D >: Animal]
  var d = new Anything[LivingThing]

  abstract class MyList[+A] {
    def head: A
    def tail : MyList[A]
    def isEmpty: Boolean
    def add[B >: A](n:B): MyList[B]
  }

  object Empty[A] extends MyList {
    def head: A = throw new NoSuchElementException
    def tail : MyList = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add(n:Int): MyList = new Cons(n, Empty)
  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h
    def tail : MyList[A] = t
    def isEmpty: Boolean = false
    def add[B>:A](n:B): MyList[B] = new Cons(n, this)
  }


}
