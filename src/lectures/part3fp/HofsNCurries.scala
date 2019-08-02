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

  def nTimesBetter (f: Int=> Int, n:Int): Int=>Int = {
    if (n <= 0 ) x=> x
    else
      x=> nTimesBetter(f, n-1)(f(x))
  }

  val supperAdder: Int => Int => Int = x=> {
        println("X=> " + x)
    y => {
      println("Y=> " + y)
      y + x
    }
  }
      val res= supperAdder(1)
  println(res)
      val plus10 = nTimesBetter(x=> x+1, 10)

      def curriedFormatter(c:String)(d:Double):String = c.format(d)
      val standardFormat: Double=>String= curriedFormatter("%4.2f")
      val resString = standardFormat(Math.PI)
      println(resString)


  def toCurry(f:(Int,Int)=>Int):Int=>Int=>Int = x=>y=> f(x,y)
  def fromCurry(f:Int=>Int=>Int):(Int,Int)=>Int = (x,y)=> f(x)(y)

  def compose[A,B,T](f:A=>B, g:T=>A): T=>B = {
    x=>f(g(x))
  }

  def andThen[A,B,C](f:A=>B,g:B=>C):A=>C = {
    x=>g(f(x))
  }

  def superAdder2: (Int=>Int=>Int) = toCurry(_+_)

}
