package lectures.part2oop

object OOBasics extends App {
//  var aPerson = new Person("John", 99)
//  println(aPerson.age)
//  aPerson.age = 2


  val counter = new Counter()
  counter.inc(5).print
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

class Counter(val count:Int = 0) {
  def inc: Counter = {
    println(s"current value is $count")
    println("Incrementing..")
    new Counter(count + 1) //immutability
  }

  def dec: Counter = {
    println("Decrementing..")
    new Counter(count - 1)
  }

  def inc(n:Int): Counter = {
    def incHelper(n:Int , counter: Counter): Counter = {
      if (n == 0 ) counter
      else
      println(this)
        incHelper(n - 1, counter.inc)
    }
    incHelper(n, this)
  }

//  def dec(n:Int): Counter = {
//    def decHelper(n:Int , counter: Counter): Counter = {
//      if (n <= 0 ) this
//      else
//        decHelper(n - 1, dec)
//    }
//    decHelper(n, this)
//  }

//  def inc(n:Int) : Counter = {
//    if (n <= 0 ) this
//    else
//      inc.inc(n - 1)
//  }

  def print = println(this.count)
}