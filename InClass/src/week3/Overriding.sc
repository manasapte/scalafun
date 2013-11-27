package week3

object Overriding {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  abstract class Base {
  	def foo = 1
  	def bar: Int
  }
  
  class Derived extends Base {
    override def foo = 3
    def bar: Int = foo
  }
}