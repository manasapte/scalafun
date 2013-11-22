package week1

object SqrtWithCorrectScoping {
  
  def sqrt(num: Double) = {
  	def abs(x: Double) = if(x<0) -x else x
  	
  	def isGoodEnough(guess: Double) = abs(guess * guess - num) / num < 0.001
  	
  	def improve(guess: Double) = (num/guess + guess) / 2
  	
  	def sqrtIter(guess: Double): Double = {
  		if(isGoodEnough(guess)) guess else sqrtIter(improve(guess))
  	}
  	sqrtIter(1)
  }                                               //> sqrt: (num: Double)Double
  
  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(1e-6)                                      //> res1: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res2: Double = 1.0000788456669446E30
}