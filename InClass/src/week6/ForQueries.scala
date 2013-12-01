package week6

object ForQueries extends App {
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
  // Find the titles of books whose author's name is Bird
  val t = for(b <- books; a <- b.authors if a startsWith("Bloch, ")) yield b.title
  println(t)
  
  // Find all the books which have the word "Program" in the title
  val s = for(b <- books if b.title.indexOf("Program") != -1) yield b.title
  println(s)
  // names of all authors who have written at least two books present in the db.
  val auths = for {
    b1 <- books
    b2 <- books
    if b1.title != b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1
  println("authors: "+auths)
}