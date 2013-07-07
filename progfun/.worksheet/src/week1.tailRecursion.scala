package week1

object tailRecursion {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(114); 
    def gcd(a:Int, b:Int): Int = {
    if(b == 0) a else gcd(b, a % b)
    };System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(73); 
    
    def factorial(a:Int): Int = if(a==0 ) 1 else a * factorial(a-1);System.out.println("""factorial: (a: Int)Int""");$skip(18); val res$0 = 
    factorial(12);System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
    factorial(6);System.out.println("""res1: Int = """ + $show(res$1));$skip(17); val res$2 = 
    factorial(4);System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
    factorial(2);System.out.println("""res3: Int = """ + $show(res$3));$skip(17); val res$4 = 
    factorial(1);System.out.println("""res4: Int = """ + $show(res$4));$skip(17); val res$5 = 
    factorial(0);System.out.println("""res5: Int = """ + $show(res$5));$skip(14); val res$6 = 
    gcd(13,4);System.out.println("""res6: Int = """ + $show(res$6));$skip(13); val res$7 = 
    gcd(2,4);System.out.println("""res7: Int = """ + $show(res$7));$skip(13); val res$8 = 
    gcd(4,4);System.out.println("""res8: Int = """ + $show(res$8));$skip(17); val res$9 = 
    gcd(120,144);System.out.println("""res9: Int = """ + $show(res$9));$skip(160); 
    
    def factorialTailRec(a:Int) = {
        def factorial(prod: Int,a: Int): Int = if(a == 0) prod else factorial(prod*a,a-1)
        factorial(1,a)
    };System.out.println("""factorialTailRec: (a: Int)Int""");$skip(30); val res$10 = 
    
    factorialTailRec(10);System.out.println("""res10: Int = """ + $show(res$10));$skip(18); val res$11 = 
    factorial(10);System.out.println("""res11: Int = """ + $show(res$11));$skip(25); val res$12 = 
    factorialTailRec(10);System.out.println("""res12: Int = """ + $show(res$12));$skip(24); val res$13 = 
    factorialTailRec(2);System.out.println("""res13: Int = """ + $show(res$13));$skip(24); val res$14 = 
    factorialTailRec(1);System.out.println("""res14: Int = """ + $show(res$14));$skip(24); val res$15 = 
    factorialTailRec(0);System.out.println("""res15: Int = """ + $show(res$15))}
}
