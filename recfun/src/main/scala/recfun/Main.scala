package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c>r) throw new IllegalArgumentException()
    else if(c==0 || c==r) 1 
    else (pascal(c,r-1) + pascal(c-1,r-1))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balIter(stack: Int,chars: List[Char]): Boolean = {
      if(stack < 0) false
      else if(stack == 0 && chars.isEmpty) true
      else if(chars.isEmpty) false
      else if(chars.head == '(') balIter(stack+1,chars.tail)
      else if(chars.head == ')') balIter(stack-1,chars.tail)
      else balIter(stack,chars.tail)
    }
    balIter(0,chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) 1
    else if(coins.isEmpty) 0
    else if(money >= coins.head) countChange(money-coins.head,coins) + countChange(money,coins.tail)
    else countChange(money,coins.tail)
  }
}
