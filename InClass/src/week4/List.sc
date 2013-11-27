package week4

object List {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
/**
 * Cons list is built using 2 building blocks
 * 1. empty list Nil
 * 2. cell that contains the first element
 *     and a pointer to the rest of the list Cons
 */
  trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
  }
 
  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty: Boolean = false
  }
  
  class Nil[T] extends List[T] {
    def isEmpty: Boolean = true
    def head: Nothing = throw new NoSuchElementException("Nil.head")
    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  }
  // Define an object List{...} with 3 functions in it so that users can create lists of length 0-2 using syntax
  // List() //the empty list
  // List(1) //the list with single element 1.
  //   List(2, 3) // the list with elements 2 and 3
  
  object List {
    def apply[T](): List[T] = new Nil[T]
      
    def apply[T](x1: T, x2: T): List[T] = new Cons[T](x1,new Cons[T](x2, new Nil[T]))
    
    def apply[T](x: T) = new Cons[T](x, new Nil[T])
    
  }
  List()                                          //> res0: week4.List.List[Nothing] = week4.List$$anonfun$main$1$Nil$1@7d38e667
  List(1)                                         //> res1: week4.List.Cons[Int] = week4.List$$anonfun$main$1$Cons$1@2c6487a9
  List(2, 3)                                      //> res2: week4.List.List[Int] = week4.List$$anonfun$main$1$Cons$1@7c067f03
  
}