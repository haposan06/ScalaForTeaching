package lectures.part3fp

object HofsNCurries extends App {
  val superFunction: (Int, (String,(Int => Boolean)) => Int) =>  (Int=>Int) = null

  def nTimes(f: Int=>Int, n:Int, x:Int): Int = {
    if (n <= 0) x
    else
      nTimes(f, n-1, f(x))
  }

  val plusOne = new Function[Int, Int] {
    override def apply(v1: Int) = v1 + 1
  }

  val result = nTimes(x => x + 1 , 2, 1)
  println(result)
}
