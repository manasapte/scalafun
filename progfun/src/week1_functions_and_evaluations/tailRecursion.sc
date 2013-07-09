package week1

object tailRecursion {
    def gcd(a:Int, b:Int): Int = {
    if(b == 0) a else gcd(b, a % b)
    }                                             //> gcd: (a: Int, b: Int)Int
    
    def factorial(a:Int): Int = if(a==0 ) 1 else a * factorial(a-1)
                                                  //> factorial: (a: Int)Int
    factorial(12)                                 //> res0: Int = 479001600
    factorial(6)                                  //> res1: Int = 720
    factorial(4)                                  //> res2: Int = 24
    factorial(2)                                  //> res3: Int = 2
    factorial(1)                                  //> res4: Int = 1
    factorial(0)                                  //> res5: Int = 1
    gcd(13,4)                                     //> res6: Int = 1
    gcd(2,4)                                      //> res7: Int = 2
    gcd(4,4)                                      //> res8: Int = 4
    gcd(120,144)                                  //> res9: Int = 24
    
    def factorialTailRec(a:Int) = {
        def factorial(prod: Int,a: Int): Int = if(a == 0) prod else factorial(prod*a,a-1)
        factorial(1,a)
    }                                             //> factorialTailRec: (a: Int)Int
    
    factorialTailRec(10)                          //> res10: Int = 3628800
    factorial(10)                                 //> res11: Int = 3628800
    factorialTailRec(10)                          //> res12: Int = 3628800
    factorialTailRec(2)                           //> res13: Int = 2
    factorialTailRec(1)                           //> res14: Int = 1
    factorialTailRec(0)                           //> res15: Int = 1
}