package DataStructures

sealed trait Queue[+A]
case class Node[A](value: A) extends Queue[A]
case class Cons[A](head: A, tail: Queue[A]) extends Queue[A]

// Is the structure of a Queue simply the same as LinkedList but with different constraints?
object Queue {
  val queue: Queue[Int] = Node(0)

  // Aren't we just rewriting the Tree data structure into a queue
  def asList[T](queue: Queue[T]): List[T] = queue match {
    case Node(a) => List(a)
    case Cons(head, tail) =>
  }
}