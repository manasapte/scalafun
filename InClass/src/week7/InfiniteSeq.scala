package week7

object InfiniteSeq extends App {
  def from(n: Int): Stream[Int] = n #:: from(n + 1)
  val nats = from(0)
  println("natural nos: " + nats)
  val mults4 = nats map (_ * 4)
  println(mults4.take(1000).toList)
  // Sieve of eratosthenes
  def sieve(nums: Stream[Int]): Stream[Int] =
    nums.head #:: sieve(nums.tail filter (_%nums.head != 0))
    
  val primes = sieve(from(2))
  println(primes.take(100).toList)

}