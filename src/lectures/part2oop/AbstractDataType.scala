package lectures.part2oop

object AbstractDataType extends App{
  abstract class Animal {
    var creatureType:String
    def eat:Unit
  }

  trait Living {
    def liveWith(animal: Animal) : Unit
  }

  trait Carn extends Living {
    def eat(animal: Animal): Unit
  }

  class Dog extends Animal with Carn {
    var creatureType = "Dog"

    def eat: Unit = ???

    override def eat(animal: Animal): Unit = ???

    override def liveWith(animal: Animal): Unit = ???
  }
}
