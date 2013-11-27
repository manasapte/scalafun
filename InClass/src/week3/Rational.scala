package week3
/**
 * Type is a set of values, values that belong to a class type are objects
 * The class definition here creates two things, a constructor named Rational
 * and a type called Rational. Scala keeps both of them in different namespaces
 * and knows which one you are refering to based on the context.
 */

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero") // Test that is performed when the class is initialized
  def this(x: Int) = this(x, 1)
  def add(that: Rational) =
    new Rational((numer * that.denom + denom * that.numer), denom * that.denom)
  override def toString = numer + "/" + denom
  def neg = new Rational(-numer, denom)
  def sub(that: Rational) = add(that.neg)
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  private def g = gcd(x, y)
  def numer = x / g
  def denom = y / g
  def less(that: Rational) = this.numer * that.denom < this.denom * that.numer
  def max(that: Rational) = if(this.less(that)) that else this
}