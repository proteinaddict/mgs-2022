package functions

object ChallngingExercises2 {
  def pythagoreamtriple(m: Int, n: Int): List[List[Int]] = {
    for { c <- (m to n).toList
          b <- (m to n).toList
          a <-  (m to n).toList
          if (a*a + b*b == c*c)
             if (a < b)
               } 
               yield List(a, b, c)
              }


  def main(argv: Array[String]): Unit = {
    println(pythagoreamtriple(1, 613))

  }
}
