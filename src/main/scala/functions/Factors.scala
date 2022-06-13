package functions

object Factors {

  def factor1(n: Int, k: Int, done: List[Int]): List[Int] = {
    if (n == 1)
      done
    else if (n % k == 0)
      factor1(n / k, k, k :: done)
    else
      factor1(n, k + 1, done)
  }

  def factors(n: Int): List[Int] = {
    factor1(n, 2, List())
  }

  def factorsOfFactorial(n:Int):Map[Int,Int] = {
    val fs = for{k <- (2 to n).toList
        f <- factors(k)
        } yield f
    for {(f, fs) <- fs.groupBy(identity)
         } yield f -> fs.size
  }

  def main(argv: Array[String]): Unit = {
    for {n <- 2 to 100
         } {
      println(s"$n --> ${factors(n)}")
      println(s"     $n! --> ${factorsOfFactorial(n)}")
    }
  }
}
