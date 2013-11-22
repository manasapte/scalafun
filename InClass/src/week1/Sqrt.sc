package week1

object Sqrt {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def abs(x: Double) = if(x<0) -x else x          //> abs: (x: Double)Double
  
  def isGoodEnough(guess: Double, num: Double) =
  	abs(guess*guess - num) / num < 0.001      //> isGoodEnough: (guess: Double, num: Double)Boolean
    
  def improve(guess: Double, num: Double) = ((num/guess) + guess) / 2
                                                  //> improve: (guess: Double, num: Double)Double
    
  def sqrtIter (guess: Double, num: Double): Double =
    if(isGoodEnough(guess, num)) guess
    else sqrtIter(improve(guess,num), num)        //> sqrtIter: (guess: Double, num: Double)Double
  
  def sqrt(num: Double) = sqrtIter(1,num)         //> sqrt: (num: Double)Double
  sqrt(400)                                       //> res0: Double = 20.000109257780434
  sqrt(2)                                         //> res1: Double = 1.4142156862745097
  sqrt(1e-6)                                      //> res2: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res3: Double = 1.0000788456669446E30
}