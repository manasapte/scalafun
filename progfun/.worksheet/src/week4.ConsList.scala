package week4

object ConsList {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet")}
}

trait List[T] {
  def head: T
  def tail: List[T]
  def isEmpty: Boolean
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  def isEmpty: Boolean = true
}

object List {
  def apply[T](t1: T,t2: T): List[T] = new Cons(t1,new Cons(t2,new Nil))
  def apply[T](): List[T] = new Nil
  def apply[T](t1: T): List[T] = new Cons(t1, new Nil)
}
