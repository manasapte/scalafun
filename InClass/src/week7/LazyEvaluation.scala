package week7

object LazyEvaluation extends App {
  /**
   * We have seen the concept of Streams in the previous section, there is still
   * one problem with that implementation of Streams. When the tail is
   * evaluated repeatedly. Scala uses the concept of lazy evaluation to avoid this
   * the tail should only be evaluated once, and stored somewhere and all the future
   * references to the tail should reuse that value.
   * So basically lazy evaluation means
   * 1. evaluating somethin just when it is needed.
   * 2. not evaluating anything twice.
   */
  // In haskell all values are by default lazy evaluated
  // scala takes a different approach, it is not a purely functional language
  // so with mutations it needs the standard vals that are evaluated
  // on creation.
  def expr = {
    val x = { print("x"); 1 }
    lazy val y = { print("y"); 2 }
    def z = { print("z"); 3 }
    z + y + x + z + y + x
  }
  println("\nexpr: " + expr)
}