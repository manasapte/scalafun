package week2_higher_order_functions

object exercise1{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(151); 

  def sum(f: Int => Int)(a:Int,b:Int): Int = {
    if(a>b) 0
    else f(a) + sum(f)(a+1,b)
  };System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(105); 
  def product(f: Int =>Int)(a: Int, b: Int): Int = {
    if(a>b) 1
    else f(a) * product(f)(a+1,b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(59); 
  
  def fact(n: Int): Int = {
    product(x =>x)(1,n)
  };System.out.println("""fact: (n: Int)Int""");$skip(23); val res$0 = 
  product(x=>x*x)(3,5);System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  fact(0);System.out.println("""res1: Int = """ + $show(res$1));$skip(10); val res$2 = 
  fact(1);System.out.println("""res2: Int = """ + $show(res$2));$skip(10); val res$3 = 
  fact(5);System.out.println("""res3: Int = """ + $show(res$3));$skip(10); val res$4 = 
  fact(3);System.out.println("""res4: Int = """ + $show(res$4));$skip(183); 
  
  def mapReduce(map: Int => Int,reduce:(Int,Int) => Int,default: Int)(a: Int, b: Int): Int = {
    if(a>b) default
    else reduce(map(a),mapReduce(map,reduce,default)(a+1,b))
  };System.out.println("""mapReduce: (map: Int => Int, reduce: (Int, Int) => Int, default: Int)(a: Int, b: Int)Int""");$skip(43); val res$5 = 
  mapReduce(x => x*x,(x,y) => x+y, 0)(3,5);System.out.println("""res5: Int = """ + $show(res$5))}
  
}
