package functions

import cats.instances.list

object pythagoreanTriples {
  def DefinedValues(a: Int, b: Int, c: Int): Boolean = (a * a + b * b == c * c)

  def triples(n: Int) = {
      println(s"here n = $n")
    for {
      a <- 1 to n
      b <- 1 to n
      c <- 1 to n
      if (a * a + b * b == c * c)
    } yield List(a, b, c)
  }

  def main(argv: Array[String]): Unit = {
    println(triples(102))
    println(DefinedValues(2, 3, 4))

  }
}
