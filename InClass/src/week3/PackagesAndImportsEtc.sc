import week3.Rational


object PackagesAndImportsEtc {
  val test = new Rational(1,2)                    //> test  : week3.Rational = 1/2

/**
 * Scala classes can only have 1 superclass
 * but they can use any number of traits.
 * Example:
 */
trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}
// This is possible: class Square extends Shape with Planar with Movable ...

/**
 * traits are like java interfaces, but more powerful
 * they can have concrete methods and fields
 * they can not have value parameters like a class though, so trait planar(width: Int, height: Int) is invalid
 */

/**
 * Type hierarchy in scala:
 * Any : base type of all other scala types
 * AnyRef: base type of all reference types - an alias to java.lang.Object
 * AnyVal: base type of all primitive types
 * Nothing: sub-type of all scala types.
 *          used to signal abnormal execution i.e. exceptions
 *          or for the element type of empty collections
 * Null: sub-type of all types that inherit from Object
 *       incompatible with the AnyVal types
 */
 
 
def x = null                                      //> x: => Null
def a: Int = 3                                    //> a: => Int
// def y: Int = null ---> does not work

}