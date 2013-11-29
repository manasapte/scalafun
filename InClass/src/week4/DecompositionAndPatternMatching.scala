package week4

object Decomposition extends App{
  /* The problem we are trying to solve is to find a general and convenient way
   * to access objects in an extensible class hierarchy
   */
  /*
   * previous attempts:
   * a. classification and accessor methods - problem is quadratic explosion of methods
   * b. type tests and casts - problem is they are unsafe and low level
   * c. Object oriented decomposition - does not work, need to touch all the classes
   *                                    in order to add new methods
   */
  trait Expr {
    def eval(): Int = this match {
      case Number(n) => n
      case Sum(e1, e2) => e1.eval() + e2.eval()
      case Var(x) => throw new Error("var.eval")
      case Prod(e1, e2) => e1.eval() * e2.eval()
    }
    def prodShowHelper(): String = this match {
      case Sum(e1, e2) => "(" + e1.show() + "+" + e2.show() + ")"
      case _=> this.show()
    }
    def show(): String = this match {
      case Number(n) => n.toString
      case Sum(e1, e2) => e1.show() + "+" +  e2.show()
      case Var(x) => x
      case Prod(e1, e2) => e1.prodShowHelper() + "*" + e2.prodShowHelper() 
    }
    
  }
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Var(x: String) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr
  /* These classes are empty, scala creates companion objects for case classes
   * like
   * object Number {
   *   def apply(n: Int) = new Number(n)
   * }
   * object Sum {
   *   def apply(e1: Expr, e2: Expr) = new Sum(e1, e2)
   * }  
   */
  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
  }
  def show(e: Expr): String = e match {
      case Number(n) => n.toString()
      case Sum(e1, e2) => show(e1) + "+" + show(e2)
  }
  /*
   * we can also add the same method inside the trait
   */ 
  println(Sum(Prod(Number(2), Var("x")), Var("y")).show())
  println(Prod(Sum(Number(2), Var("x")), Var("y")).show())
  
}