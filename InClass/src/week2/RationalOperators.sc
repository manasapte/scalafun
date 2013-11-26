package week2

object RationalOperators {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  class Rational(x: Int, y: Int) {
    //def numer = x
    //def denom = y
    require(y != 0, "denominator must be nonzero") // Test that is performed when the class is initialized
    // Another constructor:
    def this(x: Int) = this(x, 1)

    def +(that: Rational) =
      new Rational((numer * that.denom + denom * that.numer), denom * that.denom)

    override def toString = numer + "/" + denom

    /**
     *  1. add a method neg to class Rational x.neg // evaluates to -x
     *  2. add a method sub to subtract two rational numbers
     *  3. with the given x, y, z ; what is x - y - z ?
     */

    def unary_- = new Rational(-numer, denom)

    def -(that: Rational) = this + -that

    /**
     *  Data abstraction example: Improved Rational class
     *  The current implementation does not represent the rational number
     *  in the simplest possible form. For eg: it can give 70/49
     *  We can simplify x/y on every method call, but it will be better if we do it on every
     *  instantiation.
     *  We can choose any implementation for the same representation, this is data abstraction
     */
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private def g = gcd(x, y)
    def numer = x / g
    def denom = y / g
    def <(that: Rational) = this.numer * that.denom < this.denom * that.numer
    def max(that: Rational) = if (this < that) that else this
}
}