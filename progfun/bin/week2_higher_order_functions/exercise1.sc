package week2_higher_order_functions

object exercise1{

  def sum(f: Int => Int)(a:Int,b:Int): Int = {
    if(a>b) 0
    else f(a) + sum(f)(a+1,b)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int
  def product(f: Int =>Int)(a: Int, b: Int): Int = {
    if(a>b) 1
    else f(a) * product(f)(a+1,b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  def fact(n: Int): Int = {
    product(x =>x)(1,n)
  }                                               //> fact: (n: Int)Int
  product(x=>x*x)(3,5)                            //> res0: Int = 3600
  fact(0)                                         //> res1: Int = 1
  fact(1)                                         //> res2: Int = 1
  fact(5)                                         //> res3: Int = 120
  fact(3)                                         //> res4: Int = 6
  
  def mapReduce(map: Int => Int,reduce:(Int,Int) => Int,default: Int)(a: Int, b: Int): Int = {
    if(a>b) default
    else reduce(map(a),mapReduce(map,reduce,default)(a+1,b))
  }                                               //> mapReduce: (map: Int => Int, reduce: (Int, Int) => Int, default: Int)(a: Int
                                                  //| , b: Int)Int
  mapReduce(x => x*x,(x,y) => x+y, 0)(3,5)        //> res5: Int = 50
  
}