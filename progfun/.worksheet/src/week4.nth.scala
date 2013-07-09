package week4
import ConsList._

object nth {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); 
  println("Welcome to the Scala worksheet");$skip(208); 
  def nth[T](n: Int, xs: List[T]): T = {
    if(n<0) throw new IndexOutOfBoundsException
    else if(xs.isEmpty) throw new IndexOutOfBoundsException
    else if(n==0) xs.head
    else nth[T](n-1,xs.tail)
  };System.out.println("""nth: [T](n: Int, xs: week4.List[T])T""")}
}
