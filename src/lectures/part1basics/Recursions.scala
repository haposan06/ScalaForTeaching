package lectures.part1basics

import scala.annotation.tailrec

object Recursions extends App {

  def factorial(n: Int): Int = {
    if (n <= 1 ) 1
    else{
      n * factorial(n - 1)
    }
  }


  def smartFactorial (n:Int) : Int = {
    @tailrec
    def factorialHelper(o: Int, accumulator: Int): Int ={
      if ( o <= 1) accumulator
      else
        factorialHelper(o - 1, o * accumulator)
    }

    factorialHelper(n, 1)
  }

  @tailrec
  def smartConcat(input:String, n:Int, accumulator:String) : String = {
    if (n <= 1 ) accumulator
    else {
      smartConcat(input, n - 1 , accumulator + input)
    }
  }
  println(smartConcat("Hello", 5 , "Hello"))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeRec(t:Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if (t <= 1 ) true
      else
        isPrimeRec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeRec(n / 2, true)
  }
  println(7/2)
  println(isPrime(7))
}
