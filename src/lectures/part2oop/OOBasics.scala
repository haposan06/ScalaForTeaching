package lectures.part2oop

object OOBasics extends App {
  var aPerson = new Person("John", 99)
  println(aPerson.age)
  aPerson.age = 2
}

class Person(name:String, var age:Int) // this is constructor

class Writer(firstName: String, surname: String, val year: Int) {
  def returnFullName():String =
    s"$firstName $surname"
}

class Novel(name:String, yearOfRelease:Int, var author: Writer) {
  def authorAge = yearOfRelease - author.year
  def isWrittenBy(author: Writer) = author == this.author

  val author2:Writer = new Writer("John", "Dick", 1978)
  this.author = author
}
