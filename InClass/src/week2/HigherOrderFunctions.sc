package week2

object HigherOrderFunctions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  /**
  * Functions that take other functions as parameters or that return other functions
  * are higher order functions.
  *
  */
  def fact(a: Int) = {
  	def factIter(n: Int, prod: Int):Int = {
  		if(n == 1) prod else factIter(n-1, n*prod)
  	}
  	factIter(a,1)
  }                                               //> fact: (a: Int)Int
  
  def cube(a: Int) = a *a*a                       //> cube: (a: Int)Int
  // Summation function
  def sumInts(a: Int, b: Int): Int = if(a > b) 0 else a + sumInts(a+1, b)
                                                  //> sumInts: (a: Int, b: Int)Int
  def sumCubes(a: Int, b: Int): Int = if(a > b) 0 else cube(a) + sumCubes(a+1, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
  def sumFacts(a: Int, b: Int): Int = if(a > b) 0 else fact(a) + sumFacts(a+1, b)
                                                  //> sumFacts: (a: Int, b: Int)Int
  sumInts(1,5)                                    //> res0: Int = 15
  sumFacts(1,5)                                   //> res1: Int = 153
  sumCubes(3,5)                                   //> res2: Int = 216
  
  def summation(f: Int=>Int, l: Int, h: Int): Int = if(l > h) 0 else f(l) + summation(f, l+1, h)
                                                  //> summation: (f: Int => Int, l: Int, h: Int)Int
  summation(fact, 1, 5)                           //> res3: Int = 153
  summation(cube, 3, 5)                           //> res4: Int = 216
  //Now let's rewrite the summation call using anonymous functions
  def sumIntsNew(l: Int, h: Int): Int = summation((x: Int) => x*x*x, l, h)
                                                  //> sumIntsNew: (l: Int, h: Int)Int
  def sumCubesNew(l: Int, h: Int): Int = summation((x: Int) => x*x*x,l,h)
                                                  //> sumCubesNew: (l: Int, h: Int)Int
  sumCubesNew(3, 5)                               //> res5: Int = 216
  sumInts(1, 5)                                   //> res6: Int = 15
  // Now let's rewrite summation using tail recursion:
  def sum(f: Int=>Int)(l: Int, h: Int) = {
    def sum_tailrec(l: Int, partsum: Int): Int = {
    	if(l > h) partsum else sum_tailrec(l+1, partsum + f(l))
    }
    sum_tailrec(l, 0)
  }                                               //> sum: (f: Int => Int)(l: Int, h: Int)Int
  /* Partially apply sum now by following the function application with _
  *  this is beautiful, composing new functions using the existing higher order functions
  *  and partial applications
  */
  def sum_ints(a: Int, b: Int) = sum(x => x)_     //> sum_ints: (a: Int, b: Int)(Int, Int) => Int
    
}