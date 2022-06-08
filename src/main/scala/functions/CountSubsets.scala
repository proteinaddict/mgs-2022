package functions

object CountSubsets {

  // TASK:
  //   countFixedSizedSubsets(n,k)
  //      Use factorial to compute the number of k-sized subsets of an n-element set.
  //      Use your function to write some tests for the k-sized subset
  //      function which was developed in class.
  def countFixedSizedSubsets(n: Int, k: Int): Int = {
    import Factorial.factorial
    ???
  }

  // We implement this function in the lecture.
  def fixedSizedSubsets[T](n: Int, objects: Set[T]): Set[Set[T]] = {
    if (n == 0)
      Set(Set())
    else
      for {
        o <- objects
        s <- fixedSizedSubsets(n - 1, objects - o)
      } yield s + o
  }

  def main(argv: Array[String]): Unit = {
    println(countFixedSizedSubsets(5, 2))
    println(fixedSizedSubsets(2, Set(10, 20, 30, 40, 50)))
  }
}
