package week1

object Conditionals extends App {
  def and(x: Boolean, y: => Boolean) = if(x) y else false
                                                  
  def or(x: Boolean, y: => Boolean) = if(x) true else y
  def loop: Boolean = loop         
  println( and(false,loop))
}