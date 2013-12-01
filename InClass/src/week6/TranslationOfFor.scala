package week6

object TranslationOfFor {
/**
 * Setup for exercises:
 */
  case class Book(authors: List[String], title: String) {
    
  }
  val books: Set[Book] = Set(
    Book(title   = "Structure and Interpretation of computer programs",
         authors = List("Ableson, Harald", "Sussman, Gerald J.")),
    Book(title   = "Introduction to Functional Programming",
         authors = List("Bird, Richard", "Wadler, Phil")),
    Book(title   = "Effective Java",
         authors = List("Bloch, Joshua")),
    Book(title   = "Java Puzzlers",
         authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(title   = "Programming in Scala",
         authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill"))
  )
  val n = 10
  def isPrime(n: Int) = (2 until n).forall( x => (n % x != 0))

  
/**
 * For expressions are translated to the following three functions:
 * a. map
 * b. flatMap
 * c. filter
 */
/*
 * Here are the mapping rules:
 * 1. A simple for expression:
 * for (x <- e1) yield e2 is translated to
 * e1.map(x => e2)
 * 
 * 2. for expression with filter:
 * for (x <- e1 if f; s) yield e2 is translated to
 * for (x1 <- e1.withFilter(x => f); s) yield e2
 * 
 * 3. for expression with multiple generators:
 * for(x <- e1; y <- e2; s) yield e3
 * e1.flatMap(x => for(y <- e2; s) yield e3)
 */
  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)
  
  (1 until n).flatMap(i => for{
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j))
  
  (1 until n).flatMap(i => 
    for( 
      j <- (1 until i).withFilter(j => isPrime(i + j))
    )  yield (i, j)
  )
  
  (1 until n).flatMap(i => 
    (1 until i).withFilter(j => isPrime(i + j)).map(j => (i, j))
  )
  
/**
 * Translate into higher order functions:
 * 
 */
  val t = for(b <- books; a <- b.authors if a startsWith "Bird") yield b.title 
  books.flatMap( b =>
    (b.authors).withFilter(x => (x startsWith "Bird")).map(x => b.title)
  )
  
/**
 * So as long as the client interface defines the methods map, flatMap and withFilter you can use
 * the for expressions for querying your classes. The most common use is for databases.
 */
}