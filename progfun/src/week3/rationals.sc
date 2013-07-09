package week3

object rationals {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = new Rational(1,3)                       //> x  : week3.Rational = 1/3
  val y = new Rational(5,7)                       //> y  : week3.Rational = 5/7
  val z = new Rational(3,2)                       //> z  : week3.Rational = 3/2
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  x - y - z                                       //> res2: week3.Rational = -79/42
  x < y                                           //> res3: Boolean = true
  x.max(y)                                        //> res4: week3.Rational = 5/7
  val strange = new Rational(1,2)                 //> strange  : week3.Rational = 1/2
  strange + strange                               //> res5: week3.Rational = 1/1
}

class Rational(x:Int, y:Int) {
  require(y!=0,"the denominator must be non zero")
  private def gcd(a: Int, b: Int): Int = if(b==0) a else gcd(b, a%b)
  private def g = gcd(x,y)
  
  def this(x:Int) = this(x,1)
  
  def numer = x / g
  def denom = y / g
  
  def +(that: Rational): Rational = new Rational((numer*that.denom + that.numer*denom),
                                                    denom*that.denom)
  override def toString = numer + "/" + denom
  
  def unary_-(): Rational = new Rational(-numer,denom)
  
  def -(that: Rational): Rational = this + -that
  
  def <(that: Rational): Boolean = (numer * that.denom) < (denom * that.numer)
  
  def max(that: Rational): Rational = if(this < that) that else this
}