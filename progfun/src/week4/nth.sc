package week4
import ConsList._

object nth {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def nth[T](n: Int, xs: List[T]): T = {
    if(n<0) throw new IndexOutOfBoundsException
    else if(xs.isEmpty) throw new IndexOutOfBoundsException
    else if(n==0) xs.head
    else nth[T](n-1,xs.tail)
  }                                               //> nth: [T](n: Int, xs: week4.List[T])T
}