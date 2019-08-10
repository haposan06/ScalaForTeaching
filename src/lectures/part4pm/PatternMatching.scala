package lectures.part4pm

import lectures.part2oop.Inheritance.{Cat, Dog}

import scala.util.Random

object PatternMatching extends App {
  var rand = new Random(System.nanoTime).nextInt(10)

  val description = rand match {
    case 1 => "the One"
    case 2 => "The Two"
    case 3 => "The three"
    case _ => "The other"
  }
  println(rand)
  println(description)
  val y = 1
  val someOfNone = y match {
    case 1 => new Dog
    case 2 => new Cat
    case _ => new Dog
  }

  trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(e1:Expr, e2:Expr) extends Expr
  case class Product(e1: Expr, e2:Expr) extends Expr

  val ops = Sum(Number(1), Number(2))

  val readableString = ops match {
    case Sum(a:Number, b:Number) =>
  }

  def show(expr: Expr):String = expr match {
    case Number(n) => s"$n"
    case Sum(e1,e2) => show(e1) + " + " + show(e2)
    case Product(e1,e2) => show(e1) + " x " + show(e2)
  }
  println(show(Product(Sum(Number(1), Number(2)), Number(3))))


}
