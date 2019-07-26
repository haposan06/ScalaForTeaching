package lectures.part2oop

import lectures.part2oop.Generics.MyAbstractList

object Generics extends App {

  class MyAbstractList[A] {
  }

  object MyAbstractList
      def emptyAbstractList[A] : MyAbstractList[A] = ???


  class MyMap[Key,Value]


  var listOfIntegers = new MyAbstractList[Int]


  class Animal
  class Dog extends Animal
  class Cat extends Animal

  class CovariantList[+A]
  var covariantList: CovariantList[Animal] = new CovariantList[Dog]

  class InvariantLst

  class Cage[C <: Animal]
  class Car
  var c = new Cage[Car]


}
