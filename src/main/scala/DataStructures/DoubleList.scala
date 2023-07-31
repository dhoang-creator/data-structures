package DataStructures

sealed trait DoubleList[+A]
case object Nil extends DoubleList[Nothing]
case class Cons[+A](head: A, tail: DoubleList[A]) extends DoubleList[A]

// would we need another case class to make the second List value point to the first?
case class headToTail[+A]()
