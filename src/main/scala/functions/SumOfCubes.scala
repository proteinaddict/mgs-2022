package functions

object SumOfCubes {
  def sumCubes(n: Int) = {
    for {
      a <- -n to n
      b <- a to n
      c <- b to n
      if a*a*a + b*b*b + c*c*c == 1
    } println(List(a, b, c))

  }

  def main(argv: Array[String]): Unit = {
    sumCubes(100)

  }
}
