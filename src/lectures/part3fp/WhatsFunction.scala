package lectures.part3fp

object WhatsFunction extends App {
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String):Int = {
      v1.toInt
    }
  }

  val adder = new Function2[Int, Int, Int] {
    def apply(v1: Int, v2: Int): Int = ???
  }

  val concatString: ((String, String) => String) = new Function2[String, String, String] {
    def apply(v1: String, v2: String): String = s"$v1$v2"
  }

  val superAdder = new Function1[Int, ((Int)=>Int)] {
    override def apply(x: Int)  = new Function[Int,Int] {
      override def apply(y:Int):Int = x + y
    }
  }
  val adder3 = superAdder(4)
  println(adder3(3))
  //can also change above statement to
  println(superAdder(4)(3))
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
