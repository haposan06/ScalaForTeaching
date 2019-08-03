package lectures.part3fp

object MapFlatmapFilterFor extends App {
  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  println(list.map(x=>x+1))
  println(list.flatMap(x=>List(x, x+2)))
    def plusOne(x:Int)= x + 1
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")

  println(chars.map(x=>numbers.map(y=>x+ "" + y)))
  println(chars.flatMap(x=>numbers.map(y=>x + "" + y)))

  val forCombinations = for {
    c <- chars if c % 2 == 0
    n <- numbers
    col <- colors
  } yield "" + c + n + "-" + col
//  println(forCombinations)

//  val testList = List.fill(3)("")
//  val vals = testList("3")
//  println(vals


}
