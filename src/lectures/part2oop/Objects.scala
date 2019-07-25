package lectures.part2oop

object Objects extends App {
  object Person{
    val N_EYES = "2"
  }

  class Person(val name:String) {

  }
  println(Person.N_EYES)
}
