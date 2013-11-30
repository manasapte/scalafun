package week5
import math.Ordering
object GenericMergesort extends App {
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (xsh :: xst, ysh :: yst) => if (lt(xsh, ysh)) xsh :: merge(xst, ys) else ysh :: merge(xs, yst)
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }
  val a = msort(List(6, -4, 12, 0, -1))((x, y) => x < y)
  val b = msort(List("Banana", "Apple", "Mango", "Peach"))((x, y) => x.compareTo(y) < 0)
  println("a: " + a + " \nb: "+ b)
  
  def msortOrd[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (xsh :: xst, ysh :: yst) => if (ord.lt(xsh, ysh)) xsh :: merge(xst, ys) else ysh :: merge(xs, yst)
      }
      val (fst, snd) = xs splitAt n
      merge(msortOrd(fst)(ord), msortOrd(snd)(ord))
    }
  }

  def msortOrdImplicit[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (xsh :: xst, ysh :: yst) => if (ord.lt(xsh, ysh)) xsh :: merge(xst, ys) else ysh :: merge(xs, yst)
      }
      val (fst, snd) = xs splitAt n
      merge(msortOrdImplicit(fst), msortOrdImplicit(snd))
    }
  }

}