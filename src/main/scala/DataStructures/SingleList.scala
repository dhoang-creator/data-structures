package DataStructures

sealed trait SingleList[+A]
case object Nil extends SingleList[Nothing]
case class Cons[+A](head: A, tail: SingleList[A]) extends SingleList[A]

object SingleList {
  def sum(ints: SingleList[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: SingleList[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  // Notice that the asterix in the method signature below is indicative of a variadic argument
  def apply[A](as: A*): SingleList[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}