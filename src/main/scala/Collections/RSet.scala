package Collections

/*
  Daniel from the RockTheJVM was able to inspect the Scala Immutable 'Set' and find the below trait signature ... how do we do this?
 */

trait RSet[A] extends (A => Boolean) {
  override def apply(x: A): Boolean = contains(x)

  def contains(x: A): Boolean
  def +(x: A): RSet[A]
  def -(x: A): RSet[A]
}

abstract case class REmpty[A] extends RSet[A] {
  def contains(x: A): Boolean = false

  def +(x: A): RSet[A]

  def -(x: A): RSet[A]
}
