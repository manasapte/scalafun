package week1
/*
  If a recusrsive function calls itself as it's last action, the function's stack
  frame can be reused. This is called tail recursion.
  => Tail recursive functions are iterative processes.
  
  In general if the last action of a function is calling another function; the same stack
  frame can be used for both the functions. Such calls are called tail calls.
*/
object TailRecursion {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  // Newton's method for GCD is tail recursive
  
  def gcd(a: Int,b: Int): Int = if(b == 0) a else gcd(b, a%b)
                                                  //> gcd: (a: Int, b: Int)Int
  
  gcd(0,1)                                        //> res0: Int = 1
  gcd(5,23)                                       //> res1: Int = 1
  gcd(4,9)                                        //> res2: Int = 1
  gcd(12,16)                                      //> res3: Int = 4
  
  // this factorial implementation is not:
  def factorial(n : Int): Int = if(n == 0 ) 1 else n * factorial(n-1)
                                                  //> factorial: (n: Int)Int
  factorial(5)                                    //> res4: Int = 120
  
  // whereas this implementation is
  def factorial_tailrec(n: Int, prod: Int): Int = if(n ==1) prod else factorial_tailrec(n-1, prod*n)
                                                  //> factorial_tailrec: (n: Int, prod: Int)Int
  factorial_tailrec(10,1)                         //> res5: Int = 3628800
}