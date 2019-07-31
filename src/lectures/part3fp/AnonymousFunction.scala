package lectures.part3fp

object AnonymousFunction {
  val superAdder = new Function1[Int, ((Int)=>Int)] {
    override def apply(x: Int)  = new Function[Int,Int] {
      override def apply(y:Int):Int = x + y
    }
  }
  val adder3 = superAdder(4)
  println(adder3(3))
  //can also change above statement to
  println(superAdder(4)(3))

  val superAdder2 = (z:Int)  => (y:Int) => z + y
}
