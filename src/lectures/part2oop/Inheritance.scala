package lectures.part2oop

object Inheritance extends App {
  class Person(name:String, age:Int)
  class Female(name:String, age:Int, hobby:String) extends Person(name, age)

  class Animal(){
    protected def eat = "eat eat"
  }

  class Dog extends Animal {
    override def eat = "crunch crunch"
  }

  val dog = new Dog
  println(dog.eat)
}
