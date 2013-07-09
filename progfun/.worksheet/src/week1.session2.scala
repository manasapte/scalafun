package week1

object session2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(53); 
  
  def abs(x:Double): Double = if(x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(80); 
  
  def improveGuess(guess: Double, x: Double): Double = (guess + x/guess) / 2;System.out.println("""improveGuess: (guess: Double, x: Double)Double""");$skip(126); 
  
  def isGoodEnough(guess: Double, x: Double): Boolean =
      if((abs(guess * guess - x)/x) < 0.001) true
      else false;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(137); 
  
  def sqrtIter(guess: Double, x: Double): Double =
      if(isGoodEnough(guess,x)) guess
      else sqrtIter(improveGuess(guess,x),x);System.out.println("""sqrtIter: (guess: Double, x: Double)Double""");$skip(51); 
  
  def sqrt(x: Double): Double = sqrtIter(1.0,x);System.out.println("""sqrt: (x: Double)Double""");$skip(13); val res$0 = 
  
  sqrt(4);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(14); val res$2 = 
  sqrt(1e-20);System.out.println("""res2: Double = """ + $show(res$2));$skip(13); val res$3 = 
  sqrt(1e60);System.out.println("""res3: Double = """ + $show(res$3))}
  }
