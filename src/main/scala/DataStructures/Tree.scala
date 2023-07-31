package DataStructures

import scala.annotation.tailrec

sealed trait Tree[+T]
case class Leaf[T](value: T) extends Tree[T]
case class Branch[T](left: Tree[T], right: Tree[T]) extends Tree[T]

object Tree extends App {
  val tree: Tree[Int] = Branch(Leaf(0), Leaf(1))

  def asList[T](tree: Tree[T]): List[T] = tree match {
    case Leaf(a) => List(a)
    case Branch(left, right) => asList(left) ::: asList(right)
  }

  def asListRecursive[T](tree: Tree[T]): List[T] = {
    @tailrec
    // Note that the accumulator should always be an int
    def asListRec(tree: Tree[T], accumulator: Int): List[T] = {
      tree match {
        case Leaf(a)             => List(a)
        // following the below pattern where you're concatenating on a list, the below seems right but isn't, maybe this is something we can break dow further?
        case Branch(left, right) => asListRec(Branch(right), accumulator + Branch(left))
      }
      asListRec(tree, 0)
    }
  }

  /*
    Within the best practices of making a tail recursive function, we have
      def loop(cur: List[Int], acc: Int): Int = cur match {
        case h :: t => loop(t, acc + h)

   */


}