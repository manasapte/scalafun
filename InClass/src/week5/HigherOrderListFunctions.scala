package week5

object HigherOrderListFunctions extends App {
/**
 * most common themes for list functions:
 * 1. transform each element of the list and return the list of results
 * 2. retrieving a list of elements satisfying a criterion
 * 3. combine all the elements of the list using an operator
 */
// 1. transform: try square list using pattern matching and map function
  def squareList(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case h :: t => (h * h) :: squareList(t)
  } 
  
  def squareListMap(xs: List[Int]): List[Int] = xs.map(x => x * x)
  
  println(squareList(List(1, 2, 3, 4)))
  
// 2. retrieve based on a criterion: implement pack that packs a consecutive repetition of elements in a list
//    in an internal list
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case List() => List()
    case h :: t => {
      val (first, second) = xs span(x => (x == h))
      first :: pack(second)
    } 
  }
  println(pack(List("a", "a", "a", "b", "b", "c", "c", "c", "d", "e", "e", "f")))
// Using pack write a function encode that produces run length encoding of the list
  def encode[T](xs: List[T]): List[(T, Int)] = {
     pack(xs).map(t => (t.head, t.length)) 
  }
  println(encode(List("a", "a", "a", "b", "c", "c", "a")))
  
// 3. combine: Complete the following definitions of the basic functions map and length on lists, such that their implementation uses foldRight:
//  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
//    (xs foldRight List[U]())( ??? )
//  def lengthFun[T](xs: List[T]): Int =
//    (xs foldRight 0)( ??? )
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())((x, y) => f(x) :: y)
    
  println("mapfun: " + mapFun[Int, Int](List(1, 2, 3, 4), x => x*x))
  
  def lengthFun[T](xs: List[T]): Int = 
    (xs foldRight 0)((x, y) => 1 + y)
  
  println("lengthfun: " + lengthFun(List(1, 2, 3)))
}