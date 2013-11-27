package week4

object FunctionsAsObjects {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  /**
   *  Function types and values are objects in scala
   *
   *
   */
   // function type A => B
   trait Function1[A, B] {
     def apply(x: A): B
   }
   // function value (x: Int) => x * x
   {
     class AnonFun extends Function1[Int, Int] {
       def apply(x: Int): Int = x * x
     }
     new AnonFun
   }                                              //> res0: AnonFun = week4.FunctionsAsObjects$$anonfun$main$1$AnonFun$1@1a754a4a
   
   // OR
   new Function1[Int, Int] {
     def apply(x: Int): Int = x * x
   }                                              //> res1: week4.FunctionsAsObjects.Function1[Int,Int] = week4.FunctionsAsObjects
                                                  //| $$anonfun$main$1$$anon$1@3896a53a
}