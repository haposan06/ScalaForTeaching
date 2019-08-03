package exercises

abstract class Maybe[+T]{
  def map[A](f: T => A):Maybe[A]
  def flatmap[A](f: T=> Maybe[A]):Maybe[A]
  def filter(f:T=>Boolean):Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {
  def map[A](f: Nothing => A): Maybe[A] = MaybeNot

  def flatmap[A](f: Nothing => Maybe[A]): Maybe[A] = MaybeNot

  def filter(f: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {
  def map[A](f: T => A): Maybe[A] = Just(f(value))

  def flatmap[A](f: T => Maybe[A]): Maybe[A] = f(value)

  def filter(f: T => Boolean): Maybe[T] = {
    if (f(value)) this
    else
      MaybeNot
  }
}