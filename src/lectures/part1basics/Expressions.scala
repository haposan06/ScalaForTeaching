package lectures.part1basics

object Expressions extends App {
  var x =  5 + 2
  println(x)

  val y = if (x < 5) true else false
  println(y)

  var aWhile = while (x < 5) {
    println(x)
    x+=1
  }

  println(aWhile)
  var xx: Unit = ()

  var aNewVariable = 4

  val aWeirdValue = (aNewVariable = 3)
  println(aWeirdValue)

  val aCodeBlock = {
    val a = "Hello"
    val b = "Dude"

    if (a == "Hello") "Lets" else "Go"
  }

  println(aCodeBlock)
}
