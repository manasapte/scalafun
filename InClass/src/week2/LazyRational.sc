package week2

object LazyRational {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  // Rationals are kept unsimplified
  val x = new LazyRational(1, 3)                  //> x  : week2.LazyRational = 1/3
  val y = new LazyRational(5, 7)                  //> y  : week2.LazyRational = 5/7
  val z = new LazyRational(3, 2)                  //> z  : week2.LazyRational = 3/2
  // y + y is again 70/49 and not 10/7
  y.add(y)                                        //> res0: week2.LazyRational = 10/7
  // LazyRational is problematic because we are using ints internally which can overflow.
  
}
class LazyRational(x: Int, y: Int) {
	def numer = x
	def denom = y
	require(y != 0, "denominator must be nonzero") // Test that is performed when the class is initialized
	// Another constructor:
	def this(x: Int) = this(x, 1)
	
	def add(that: LazyRational) =
		new LazyRational((numer*that.denom + denom*that.numer), denom*that.denom)
		
	override def toString = {
		val g = gcd(numer, denom)
		(numer/g) + "/" + (denom/g)
	}
	
	/**
	*  1. add a method neg to class LazyRational x.neg // evaluates to -x
	*  2. add a method sub to subtract two LazyRational numbers
	*  3. with the given x, y, z ; what is x - y - z ?
	*/
	
	def neg = new LazyRational(-numer,denom)
	
	def sub(that: LazyRational) = add(that.neg)
	
/**
 *  Data abstraction example: Improved LazyRational class
 *  The current implementation does not represent the LazyRational number
 *  in the simplest possible form. For eg: it can give 70/49
 *  We can simplify x/y on every method call, but it will be better if we do it on every
 *  instantiation.
 *  We can choose any implementation for the same representation, this is data abstraction
 */
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  
  def less(that: LazyRational) = this.numer * that.denom < this.denom * that.numer
  def max(that: LazyRational) = if(that.less(that)) that else this
}