package week3

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def contains(x: Int): Boolean = false
  def union(other: IntSet) = other
  override def toString() = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int) =
    if (x < elem) new NonEmpty(elem, left.incl(x), right)
    else if (x > elem) new NonEmpty(elem, left, right.incl(x))
    else this

  def contains(x: Int) =
    if (x < elem) left.contains(x)
    else if (x > elem) right.contains(x)
    else if (x == elem) true
    else false

  def union(other: IntSet) =
    if (other == Empty) this
    else left.union(right).union(other.incl(elem))

  override def toString = "(" + left + elem + right + ")"

}
object IntSet extends App {
  val s = new NonEmpty(2,Empty,Empty).incl(1).incl(100).incl(24)
  println("s: " + s)                              //> s  : week3.NonEmpty = ((.1.)2((.24.)100.))
  val t = new NonEmpty(50, Empty, Empty).incl(-5).incl(34).incl(7)
  println("t: " + t)                              //> t  : week3.NonEmpty = ((.-5((.7.)34.))50.)
  println(s union t)                                       //> res0: week3.IntSet = ((.-5((((.1.)2.)7(.24.))34.))50(.100.))
}