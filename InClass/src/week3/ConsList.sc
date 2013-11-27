package week3

object ConsList {
  println ("hi there")                            //> hi there
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
 
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)week3.ConsList.Cons[T]
  singleton(1)                                    //> res0: week3.ConsList.Cons[Int] = week3.ConsList$$anonfun$main$1$Cons$1@3c0d5
                                                  //| 2ea
  def nth[T](n: Int, l: List[T]): T =
    if(n < 0) throw new IndexOutOfBoundsException()
    else if(l.isEmpty) throw new IndexOutOfBoundsException()
    else if(n == 0) l.head
    else nth(n-1, l.tail)                         //> nth: [T](n: Int, l: week3.ConsList.List[T])T
    val l = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, new Nil[Int])))
                                                  //> l  : week3.ConsList.Cons[Int] = week3.ConsList$$anonfun$main$1$Cons$1@ebe9f7
                                                  //| 3
  nth(0, l)                                       //> res1: Int = 1
  nth(1, l)                                       //> res2: Int = 2
  nth(2, l)                                       //> res3: Int = 3
  var a: Int = 1                                  //> a  : Int = 1
  // IndexOutOfBoundsException:
  nth(-1, l)                                      //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week3.ConsList$$anonfun$main$1.nth$1(week3.ConsList.scala:30)
                                                  //| 	at week3.ConsList$$anonfun$main$1.apply$mcV$sp(week3.ConsList.scala:40)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week3.ConsList$.main(week3.ConsList.scala:3)
                                                  //| 	at week3.ConsList.main(week3.ConsList.scala)
  // nth(0, new Nil)
  
}