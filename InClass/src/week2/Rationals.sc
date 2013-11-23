package week2

object Rationals {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = new Rational(1, 3)                      //> x  : week2.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : week2.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week2.Rational = 3/2
  val a = new Rational(1, 3)                      //> a  : week2.Rational = 1/3
  /**
	*  1. add a method neg to class Rational x.neg // evaluates to -x
	*  2. add a method sub to subtract two rational numbers
	*  3. with the given x, y, z ; what is x - y - z ?
	*/
  x.sub(y).sub(z)                                 //> res0: week2.Rational = -79/42
  x.add(y)                                        //> res1: week2.Rational = 22/21
  a.add(x)                                        //> res2: week2.Rational = 2/3
  x.less(a)                                       //> res3: Boolean = false
  a.less(y)                                       //> res4: Boolean = true
  y.max(a)                                        //> res5: week2.Rational = 5/7
  val strange = new Rational(1, 0)                //> java.lang.IllegalArgumentException: requirement failed: denominator must be 
                                                  //| nonzero
                                                  //| 	at scala.Predef$.require(Predef.scala:233)
                                                  //| 	at week2.Rational.<init>(week2.Rationals.scala:35)
                                                  //| 	at week2.Rationals$$anonfun$main$1.apply$mcV$sp(week2.Rationals.scala:20
                                                  //| )
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week2.Rationals$.main(week2.Rationals.scala:3)
                                                  //| 	at week2.Rationals.main(week2.Rationals.scala)
  strange.add(strange)
  val simple = new Rational(2)
}

/**
 * Type is a set of values, values that belong to a class type are objects
 * The class definition here creates two things, a constructor named Rational
 * and a type called Rational. Scala keeps both of them in different namespaces
 * and knows which one you are refering to based on the context.
 */

class Rational(x: Int, y: Int) {
	//def numer = x
	//def denom = y
	require(y != 0, "denominator must be nonzero") // Test that is performed when the class is initialized
	// Another constructor:
	def this(x: Int) = this(x, 1)
	
	def add(that: Rational) =
		new Rational((numer*that.denom + denom*that.numer), denom*that.denom)
		
	override def toString = numer + "/" + denom
	
	/**
	*  1. add a method neg to class Rational x.neg // evaluates to -x
	*  2. add a method sub to subtract two rational numbers
	*  3. with the given x, y, z ; what is x - y - z ?
	*/
	
	def neg = new Rational(-numer,denom)
	
	def sub(that: Rational) = add(that.neg)
	
/**
 *  Data abstraction example: Improved Rational class
 *  The current implementation does not represent the rational number
 *  in the simplest possible form. For eg: it can give 70/49
 *  We can simplify x/y on every method call, but it will be better if we do it on every
 *  instantiation.
 *  We can choose any implementation for the same representation, this is data abstraction
 */
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  private def g = gcd(x, y)
  def numer = x / g
  def denom = y / g
  def less(that: Rational) = this.numer * that.denom < this.denom * that.numer
  def max(that: Rational) = if(that.less(that)) that else this
}