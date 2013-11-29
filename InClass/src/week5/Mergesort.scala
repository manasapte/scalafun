package week5

object Mergesort extends App {
  
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if(n==0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (xsh::xst, ysh::yst) => if(xsh <= ysh) xsh :: merge(xst,ys) else ysh :: merge(xs, yst)
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }
  println(msort(List(5, 4, 3, 2, 1)))
}