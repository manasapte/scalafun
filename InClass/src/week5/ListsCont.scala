package week5
import scala.List
object ListsCont extends App {
  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("empty.last")
    case List(x) => x
    case h :: t => last(t)
  }
  
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("empty.init")
    case List(x) => List()
    case h :: t => h :: init(t)
  }
  
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case h :: t => h :: concat(t, ys)
  }
  
  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => List()
    case h :: t => reverse(t) ++ List(h)  // ----> this is n * n cause we have n reverses and each concat is O(n)
  }
  
  /*
   * def removeAt[T](i: Int, xs: List[T]): List[T] = xs match {
   * case List() => List()
   * case h :: t => if(i == 0) t else h :: removeAt(i-1, t) 
   * }
   */
  def removeAt[T](i: Int, xs: List[T]): List[T] = (xs take i) ::: (xs drop i + 1)
  /*def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => List()    
    case h :: t => 
  } */
    
  println(removeAt(1, List("a","b","c","d")))
}