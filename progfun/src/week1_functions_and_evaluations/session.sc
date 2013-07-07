package week1

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def abs(x:Double): Double = if(x < 0) -x else x //> abs: (x: Double)Double
  
  def improveGuess(guess: Double, x: Double): Double = (guess + x/guess) / 2
                                                  //> improveGuess: (guess: Double, x: Double)Double
  
  def isGoodEnough(guess: Double, x: Double): Boolean =
      if((abs(guess * guess - x)/x) < 0.001) true
      else false                                  //> isGoodEnough: (guess: Double, x: Double)Boolean
  
  def sqrtIter(guess: Double, x: Double): Double =
      if(isGoodEnough(guess,x)) guess
      else sqrtIter(improveGuess(guess,x),x)      //> sqrtIter: (guess: Double, x: Double)Double
  
  def sqrt(x: Double): Double = sqrtIter(1.0,x)   //> sqrt: (x: Double)Double
  
  sqrt(4)                                         //> res0: Double = 2.000609756097561
  sqrt(2)                                         //> res1: Double = 1.4142156862745097
  sqrt(1e-20)                                     //> res2: Double = 1.0000021484861236E-10
  sqrt(1e60)                                      //> res3: Double = 1.0000788456669446E30
  
}