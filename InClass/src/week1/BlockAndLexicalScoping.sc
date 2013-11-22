package week1

object BlockAndLexicalScoping {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = 0                                       //> x  : Int = 0
  def f(y: Int) = y+1                             //> f: (y: Int)Int
  
  val block = { // this is a block
  	/*all the outer definitions are visible inside this scope, as long as
  	  they are not redefined. So definition of x is overridden but f is still
  	  what it was outside this block
  	*/
  	val x = f(3)
  	x*x
  	// x outside the block (below) is still gonna be 0
  } + x                                           //> block  : Int = 16
}