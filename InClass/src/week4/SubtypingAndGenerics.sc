package week4

object SubtypingAndGenerics {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  // Let's see the interaction between the subtyping and generics
  
  // Type Bounds --> can subject type parameters to subtype constraints
  /**
   *  consider the method assertAllPos which
   *  takes an IntSet
   *  returns the IntSet itself if all its elements are positive
   *  throws an exception otherwise
   */
   // what's the best type for assertAllPos?
  /** def assertAllPos(s: IntSet): IntSet?
   *  the behavior of assertAllPos is governed by two equations
   *  assertAllPos(Empty): Empty
   *  assertAllPos(NonEmpty): NonEmpty
   *  the above definition : assertAllPos(s: IntSet): IntSet does not capture this
   *  one way to do this is: def assertAllPos[S <: IntSet](r: S): S = ...
   */
   
   
   // Variance --> how parameterized types behave under subtyping
  /**
   *  covariance:
   *  given S <: T List[S] <: List[T]
   *
   *
   *
   */
}