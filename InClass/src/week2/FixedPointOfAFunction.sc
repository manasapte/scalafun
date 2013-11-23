package week2

object FixedPointOfAFunction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  /**
  *  A number x is called the fixed point of a function f if:
  *  x = f(x)
  *  For some functions it can be evaluated by calculating
  *  f(x), f(f(x)), f(f(f(x))) ... until convergence
  */
  
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def abs(x: Double) = if(x > 0) x else -x
    
  	def isGoodEnough(guess: Double) = {
  		abs((f(guess) - guess) / guess) / guess < 0.001
  	}
  	
  	def fixedPointRecur(guess: Double): Double = {
  		if(isGoodEnough(guess)) guess
  		else fixedPointRecur(f(guess))
  	}
  	
  	fixedPointRecur(firstGuess)
	}                                         //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
	fixedPoint(x => 1 + x/2)(1)               //> res0: Double = 1.9921875
	
	/**
	* Now let's look at our sqrt function
	* sqrt(x) = y s.t. y * y = x
	* => y s.t y = x / y
	* => fixed point of the function f(y) = x / y
	*/
	def sqrt(x: Double): Double = fixedPoint(y => (y + x/y)/2)(1)
                                                  //> sqrt: (x: Double)Double
  sqrt(400)                                       //> res1: Double = 20.06621767747577
  
  /**
  *  Now we want to abstract this idea of average damping,
  *  so we create a function that accepts a function and returns
  *  the average damped version of it. Functions returning functions are thus powerful!
  */
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  def sqrtNew(x: Double): Double = fixedPoint(averageDamp(y => x/y)_)(1)
                                                  //> sqrtNew: (x: Double)Double
  sqrtNew(400)                                    //> res2: Double = 20.06621767747577
}