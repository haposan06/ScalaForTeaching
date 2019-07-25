package lectures.part2oop

object MethodNotation extends App {

  class Person(val name:String, likes:String){
    def apply() = s"My name is $name"
    def unary_! = s"lontong"
  }

  val p = new Person("Mary","Books")
  println(!p)
  print(p())
}
