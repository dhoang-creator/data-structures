package Collections

/*
  This was taken from the Scala Collections,
    1. Go through the Scala collections graph and create each of the main ones, one by one
    2. Research the most commonly used methods from the scala language which applies to each of the collection
 */
trait traversable[A] {
  // Abstract traversable
  def foreach[E](f: E => B) = ???

  // Addition
  def ++()

}
