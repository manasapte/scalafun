package week6

object Collections extends App {
/**
 * Vectors are indexed arrays with constant time worst access
 * vectors are indexed arrays and they are immutable
 * access complexity is (log32 N)
 * 
 * Collection hierarchy is
 * Iterable: (Set, Sequence: (List, Vector, String, Array, Range), Map)
 */
  val xs = Array(1, 2, 3, 44)
  xs map (x => x*2)
  println("xs: "+xs.toString())
  val s = "Hello World"
  println(s filter (c => c.isUpper))
  
  println(s exists(c => c.isUpper))
  println(s forall(c => c.isUpper))
  println (List(1, 2, 3) zip s)
  
  // List all combinations of numbers x and y where x = {1 .. M} and y = {1 .. N}
  println ((1 to 10) flatMap (x => (1 to 20) map (y => (x, y))))
  
  // Scalar product
  def scalar(v1: Vector[Double], v2: Vector[Double]): Double =
    (v1 zip v2).map(xy => xy._1 * xy._2).sum
  
  def scalarProd(v1: Vector[Double], v2: Vector[Double]): Double =
    (v1 zip v2).map{ case (x, y) => x * y }.sum
    
  /*
   * A number n is prime if it's divisible only by 1 and itself.
   * write the most high level way to test for primality
   */
  def isPrime(n: Int): Boolean = (2 to n-1).forall(div => (n%div != 0))
  println(isPrime(12))
  println(isPrime(13))
}