package week3

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(28); 
  val x = new Rational(1,3);System.out.println("""x  : week3.Rational = """ + $show(x ));$skip(28); 
  val y = new Rational(5,7);System.out.println("""y  : week3.Rational = """ + $show(y ));$skip(28); 
  val z = new Rational(3,2);System.out.println("""z  : week3.Rational = """ + $show(z ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(12); val res$2 = 
  x - y - z;System.out.println("""res2: week3.Rational = """ + $show(res$2));$skip(8); val res$3 = 
  x < y;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(11); val res$4 = 
  x.max(y);System.out.println("""res4: week3.Rational = """ + $show(res$4));$skip(34); 
  val strange = new Rational(1,2);System.out.println("""strange  : week3.Rational = """ + $show(strange ));$skip(20); val res$5 = 
  strange + strange;System.out.println("""res5: week3.Rational = """ + $show(res$5))}
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
