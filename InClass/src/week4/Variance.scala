package week4
import scala.Boolean
import week3.Empty
import week3.NonEmpty
import week3.IntSet
object Variance extends App {
/**
 * Typing rules for functions:
 * We have the following rule for the subtyping between the function types:
 * If A2 <: A1 and B1 <: B2, then
 * A1 => B1 <: A2 => B2
 * So function types are 
 *     covariant in the return types
 * AND contravariant in argument types 
 */
 // so we can define the function trait again as follows
  trait Function1[-T, +U] {
    def apply(t: T): U
  }
/**
 *  Now let's redefine our cons list using the concept of variance.
 *  one short coming here is the Nil type is defined as a class instead of an object.
 */ 
  trait List[+T] {
    def isEmpty: scala.Boolean
    def head: T
    def tail: List[T]
    // def prepend(elem: T): List[T] = new Cons(elem, this) ---> does not work.
    def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
  }
 
  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty: scala.Boolean = false
  }
  
  object Nil extends List[Nothing] {
    def isEmpty: scala.Boolean = true
    def head: Nothing = throw new NoSuchElementException("Nil.head")
    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  }

  // Nothing is a subtype of string, and we have defined List to be covariant
  // therefore list of Nothing is a subtype of list of String
  val x: List[String] = Nil
  /*
   * some times we have to put in some work to make a type covariant.
   * Let's add a prepend operation to list.
   * prepend[T](elem: T) = new Cons(elem, this)
   * Since list is covariant in T, it can not accept T as a function argument.
   * Here's the problem
   * var xs: List[IntSet] = new ...
   * xs.prepend(Empty)
   * but then on 
   * var ys: List[NonEmpty] = new ...
   * ys.prepend(Empty) -- Fails and therefore, list is not covariant any more.
   * to solve this we can use some super type of T
   * So def prepend[U >: T](elem: T): List[U] = new Cons(elem, this) 
   */
  // What will be the return type of the following:
  def function(xs: List[NonEmpty]) = xs.prepend(Empty)
  /**
   * It is List[IntSet]. When prepend is called, compiler tries to match Empty to one of the super types of NonEmpty.
   * NonEmpty itself does not match, so it tries IntSet and that matches.
   * So now it is operating as prepend(l: List[IntSet]): List[IntSet]
   * Therefore the return type is List[IntSet]
   */
    
  
}