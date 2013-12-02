package week7

object Streams extends App {
  /**
   * Consider the problem of finding the second prime number between 1000 and 10000
   */
  def isPrime(x: Int): Boolean = (2 to x-1) forall (x%_ != 0) 
  val p = ((1000 to 10000) filter (isPrime))(1)
  println("second prime is: " + p)
  /**
   * The issue with the above solution is that it precomputes all the prime
   * numbers in the range. We want to be able to keep the elegance of this
   * solution but make it lazy, so that it can just not evaluate the tail of
   * the sequence if it's not necessary.
   * This idea is implemented in a new class Stream
   */
  val q = ((1000 to 10000).toStream filter (isPrime))(1)
  println("second prime is: " + q)
  /**
   * #:: is the cons operator for streams
   * implementation detail of streams: they just use the cons parameter by reference
   * that means, the head is always evaluated and the tail or thereby any functions of the tail
   * are just passed on by reference.
   */
}