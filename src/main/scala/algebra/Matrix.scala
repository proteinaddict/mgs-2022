package algebra

object Matrix {
  type MATRIX = Vector[Vector[Double]]

  def dimension(m: MATRIX): Int = {
    m.size
  }

  // generate a matrix of the specified dimension, with each
  //  element within the matrix a number between the given upper and lower bounds.
  def matrixRandom(dim: Int, lower:Double= -10.0, upper:Double = 10): MATRIX = {
    import scala.util.Random
    val rand = new Random()
    assert(dim >= 0)
    Vector.tabulate(dim) {
      row => Vector.tabulate(dim) {
        col => rand.between(lower, upper)
      }
    }
  }

  // to print a MATRIX we must convert it to a string, and print that string.
  // This function converts to a string which will be printed in a format
  // such as:
  // [1.0, 2.0, 3.0
  //  2.0, 3.0, 5.0
  //  2.0, -1.0, 0.0 ]
  def matrixToString(m: MATRIX): String = {
    val rows = for {v <- m
                    } yield v.mkString(", ")
    rows.mkString("[", "\n ", " ]")
  }

  def matrixIdentity(dim: Int): MATRIX = {
    Vector.tabulate(dim) {
      row =>
        Vector.tabulate(dim) {
          col => if (row == col) 1.0 else 0.0
        }
    }
  }

  def matrixAdd(a: MATRIX, b: MATRIX): MATRIX = {
    assert(dimension(a) == dimension(b))
    Vector.tabulate(dimension(a)) {
      row =>
        Vector.tabulate(dimension(a)) {
          col => a(row)(col) + b(row)(col)
        }
    }
  }

  def matrixScale(alpha: Double, m: MATRIX): MATRIX = {
    Vector.tabulate(dimension(m)) {
      row => Vector.tabulate(dimension(m)) {
        col => alpha * m(row)(col)
      }
    }
  }

  def matrixSubtract(a: MATRIX, b: MATRIX): MATRIX = {
    matrixAdd(a, matrixScale(-1.0, b))
  }

  def matrixMultiply(a: MATRIX, b: MATRIX): MATRIX = {
    assert(dimension(a) == dimension(b))
    Vector.tabulate(dimension(a)) {
      row =>
        Vector.tabulate(dimension(a)) {
          col => Vector.tabulate(dimension(a)){
            k => a(row)(k) * b(k)(col)
          }.sum
        }
    }
  }

  def matrixTranspose(m: MATRIX): MATRIX = {
    ???
  }

  def matrixPower(m: MATRIX, p: Int): MATRIX = {
    ???
  }

  def matrixAlmostEqual(a: MATRIX, b: MATRIX, epsilon: Double): Boolean = {
    ???
  }

  def threeConsecutiveFibonacci(n: Int): (Int, Int, Int) = {
    ???
  }

  def main(argv: Array[String]): Unit = {
    val m = Vector(Vector(1.0, 2.0, 3.0),
                   Vector(2.0, 3.0, 5.0),
                   Vector(2.0, -1.0, 0.0))
    val p = Vector(Vector(2.0, 2.0, 3.0),
                   Vector(-2.0, 1.0, 0.0),
                   Vector(-2.0, -1.0, 0.0))
    println(matrixToString(m))
    println(matrixToString(matrixRandom(4)))
    println(matrixToString(matrixIdentity(4)))
    println(matrixToString(matrixAdd(m, m)))
    println(matrixToString(matrixSubtract(m, m)))
    println(matrixToString(matrixMultiply(m, p)))
    println(matrixToString(matrixMultiply(p,matrixIdentity(3))))
  }
}
