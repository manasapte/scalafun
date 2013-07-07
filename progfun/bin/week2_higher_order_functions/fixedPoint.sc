package week2_higher_order_functions
import math.abs
object fixedPoint {
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
  }                                               //> fixedPoint: (f: Double => Double)(guess: Double)Double
  /*def sqrt(x: Double): Double = {
    fixedPoint(y => (y + x/y)/2 )(1)
  }*/
  def averageDamp(f: Double=>Double,x: Double): Double = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double, x: Double)Double
  def sqrt(x: Double): Double = fixedPoint(y => averageDamp(y => x/y,y))(1)
                                                  //> sqrt: (x: Double)Double

  sqrt(25)                                        //> res0: Double = 5.000023178253949
}