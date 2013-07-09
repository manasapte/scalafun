package week3

object classesandobjects {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(85); 
  println("Welcome to the Scala worksheet");$skip(57); 
  val test = new NonEmpty(7,Empty,Empty).incl(5).incl(3);System.out.println("""test  : week3.IntSet = """ + $show(test ))}
}

abstract class IntSet {
  def incl(x:Int): IntSet
  def contains(x:Int): Boolean
  def union(that:IntSet): IntSet
}

object Empty extends IntSet {
  def incl(x:Int): IntSet = new NonEmpty(x,Empty,Empty)
  def contains(x:Int): Boolean = false
  def union(that: IntSet): IntSet = that
  override def toString = "."
}

class NonEmpty(elem:Int,left:IntSet,right:IntSet) extends IntSet {
  def incl(x:Int): IntSet = if(x <= elem) new NonEmpty(elem,left.incl(x),right) else new NonEmpty(x,left,right.incl(x))
  def contains(x:Int):Boolean = {
  if(x < elem) left.contains(x)
  else if(x > elem) right.contains(x)
  else true
  }
  def union(that: IntSet): IntSet = left.union(right).incl(elem).union(that)
  override def toString = "{" + left + elem + right + "}"
}
