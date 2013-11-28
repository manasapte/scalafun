package week4

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def succesor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = True
  def predecessor: Nat = throw new Error("0.predecessor")
  def succesor: Nat = new Succ(this) 
  def +(that: Nat): Nat = that
  def -(that: Nat): Nat = throw new Error("0.-")
}

class Succ(val predecessor: Nat) extends Nat {
  def isZero: Boolean = False
  def succesor: Nat = new Succ(this) 
  def +(that: Nat): Nat = predecessor + new Succ(that)
  def -(that: Nat): Nat = if(that.isZero) this else predecessor - that.predecessor
}