package week2

object Currying {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  // Let's consider the example from higher order functions:
  def sum(f: Int => Int): (Int, Int) => Int = {
  	def sumF(l: Int, h: Int): Int = if(l > h) 0 else l+ sumF(l+1, h)
  	sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int
  
  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  sumInts(1,5)                                    //> res0: Int = 15
  // The above definition can be re-written using currying
  def summation(f: Int => Int)(l: Int, h: Int) = {
  	def loop(l: Int, acc: Int): Int = if(l > h) acc else loop(l+1, acc + f(l))
  	loop(l,0)
  }                                               //> summation: (f: Int => Int)(l: Int, h: Int)Int
  // Note that function application is left associative
  def sum_ints = summation(x => x)_               //> sum_ints: => (Int, Int) => Int
  /* The return type is right associative, summation is (Int=>Int) => (Int, Int) => Int
  *  this style of function definitions is called currying.
  *
  */
  def sum_cubes = summation(x => x*x*x)_          //> sum_cubes: => (Int, Int) => Int
  sum_cubes(1,3)                                  //> res1: Int = 36
}