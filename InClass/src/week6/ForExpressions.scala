package week6

object ForExpressions extends App {
/**
 * generate all 1 <= j < i < n such that i + j is prime
 */
  def isPrime(n: Int): Boolean = (2 to n-1).forall(div => (n%div != 0))
  def myNums(n: Int) = {
    val t = ((1 until n) flatMap (i =>
      (1 until i) map (j => (i, j))
    )) filter (pair => isPrime(pair._1 + pair._2))
    
    println(t)
  }
  myNums(10)
  // The above syntax makes your head hurt, let's bring in for expressions
  val s = for {
    i <- 1 to 10
    j <- 1 to i
    if isPrime(i + j)
  } yield (i, j)
  println("s: "+s)
  
  // Write a version of scalar product that uses for expressions
  def scalarProduct(v1: Vector[Double], v2: Vector[Double]): Double = {
    (for((x, y) <- v1 zip v2) yield x * y) sum
  }
  val v1 = Vector(1.0, 2, 3)
  val v2 = Vector(1.5, 2.5, 3.3)
  println(scalarProduct(v1, v2))
}