package week2_higher_order_functions
import math.abs
object fixedPoint {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(447); 
  def fixedPoint(f: Double => Double)(guess: Double): Double = {
    val threshold = 0.001
    def isGoodEnough(x:Double, y:Double): Boolean = {
      if(abs(((x-y)/x)/x) < threshold) true
      else false
    }
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if(isGoodEnough(guess,next)) next
      else iterate(next)
    }
    iterate(guess)
  };System.out.println("""fixedPoint: (f: Double => Double)(guess: Double)Double""");$skip(151); 
  /*def sqrt(x: Double): Double = {
    fixedPoint(y => (y + x/y)/2 )(1)
  }*/
  def averageDamp(f: Double=>Double,x: Double): Double = (x + f(x)) / 2;System.out.println("""averageDamp: (f: Double => Double, x: Double)Double""");$skip(76); 
  def sqrt(x: Double): Double = fixedPoint(y => averageDamp(y => x/y,y))(1);System.out.println("""sqrt: (x: Double)Double""");$skip(12); val res$0 = 

  sqrt(25);System.out.println("""res0: Double = """ + $show(res$0))}
}
