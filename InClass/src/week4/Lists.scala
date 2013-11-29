package week4
import scala.List

object Lists {
  /**
   * Let's sort lists using list pattern matching and insertion sort algorithm.
   */
  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case h :: t => if(x <= h) x :: xs else h :: insert(x, t)
  }
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case h :: t => insert(h, isort(t))
  }
}