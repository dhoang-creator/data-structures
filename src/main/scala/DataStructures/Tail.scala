package DataStructures

import scala.annotation.tailrec

object Tail {

  @tailrec
  def sumExample(list: List[Int]): Int = sumWithAccumulatorExample(list, 0)

  @tailrec
  private def sumWithAccumulatorExample(list: List[Int], accumulator: Int): Int = list match {
    case Nil      => accumulator
    case x :: xs  => sumWithAccumulatorExample(xs, accumulator + x)
  }

  /*
    With the below, we:
    1. created the tail recursive function within the original function
    2. utilised the use of an accumulator which acts as the tail value
    3. as the final case match, called upon the tailrec method
    4. outside of the tail recursive function but still inside the main function, called the tail recursive function, applying the appropriate params
   */

  def sum(list: List[Int]): Int = {
    @tailrec
    def sumWithAccumulator(list: List[Int], currentSum: Int): Int = {
      list match {
        case Nil      => currentSum
        case x :: xs  => sumWithAccumulator(xs, currentSum + x)
      }
    }
    sumWithAccumulator(list, 0)
  }
}
