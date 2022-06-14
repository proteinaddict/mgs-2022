package functions

object Factors {

  def factorSearch(n: Int, k: Int, done: List[Int]): List[Int] = {
    // recursively find factors of n, each time a factor is
    // found, prepend k onto done, if factor not found, 
    // increment k
    ???
  }

  def factors(n: Int): List[Int] = {
    ???
  }

  def factorsOfFactorial(n: Int): List[Int] = {
    // return a list of the factors of n!
    ???
  }

  def cancel(
      nFactors: List[Int],
      dFactors: List[Int],
      qFactors: List[Int]
  ): List[Int] = {
    ???
  }

  def choose(n: Int, k: Int): Int = {
    // compute number of combinations of n things taken k at a time.
    // we do this by expanding all the factors and canceling,
    // finally multiplying the reduced numerator
    ???
  }

  def main(argv: Array[String]): Unit = {
    import functions.Factorial.factorial

    for { n <- 2 to 100 } {
      println(s"$n --> ${factors(n)}")
      println(s"     $n! --> ${factorsOfFactorial(n)}")
    }
    for {
      n <- 2 to 20
      k <- 1 to n
      c1 = choose(n, k)
      c2 = factorial(n) / (factorial(k) * (factorial(n - k)))
      if c1 != c2
    } println(s"n=$n k=$k c1=$c1 c2=$c2")
  }
}
