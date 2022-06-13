package algebra

object Matrix {
  // We represent a square MATRIX as a Vector of Vectors of Double.
  // E.g., if the MATRIX has dimension 7, that means it has size 7 x 7,
  // We can extract the element from row 4, column 2 as m(4)(2)
  type MATRIX = Vector[Vector[Double]]

  def dimension(m: MATRIX): Int = {
    m.size
  }

  // generate a matrix of the specified dimension, with each
  //  element within the matrix a number between the given upper
  //  and lower bounds.
  def matrixRandom(
      dim: Int,
      lower: Double = -10.0,
      upper: Double = 10.0
  ): MATRIX = {
    import scala.util.Random
    val rand = new Random()
    assert(dim >= 0)
    Vector.tabulate(dim) { row =>
      Vector.tabulate(dim) { col =>
        rand.between(lower, upper)
      }
    }
  }

  // To print a MATRIX we must convert it to a string, and print that string.
  // This function converts the MATRIX to a string which will be printed in
  // a format such as:
  // [1.0, 2.0, 3.0
  //  2.0, 3.0, 5.0
  //  2.0, -1.0, 0.0 ]
  def matrixToString(m: MATRIX): String = {
    val rows = for { v <- m } yield v.mkString(", ")
    rows.mkString("[", "\n ", " ]")
  }

  // create a new MATRIX of dimension dim x dim, which is populated
  // by the given tabulate function.  i.e., row r, col c becomes the
  // return value of tabulate(r,c)
  def matrixTabulate(dim: Int, tabulate: (Int, Int) => Double): MATRIX = {
    Vector.tabulate(dim) { row =>
      Vector.tabulate(dim) { col =>
        tabulate(row, col)
      }
    }
  }

  // create a new square MATRIX of dimension dim
  // with 1.0 on the main diagonal, and 0.0 elsewhere.
  def matrixIdentity(dim: Int): MATRIX = {
    matrixTabulate(dim, (row, col) => if (row == col) 1.0 else 0.0)
  }

  // given two square matrices of the same dimension dim,
  // create a new MATRIX which corresponds to the sum of the two
  // input matrices.
  def matrixAdd(a: MATRIX, b: MATRIX): MATRIX = {
    assert(dimension(a) == dimension(b))
    matrixTabulate(
      dimension(a), // the dimensions are the same
      (row, col) => a(row)(col) + b(row)(col)
    )
  }

  // given a square MATRIX of dimension dim, create a new
  // MATRIX which every entry scaled (multiplied by) the
  // given alpha.
  def matrixScale(alpha: Double, m: MATRIX): MATRIX = {
    matrixTabulate(
      dimension(m),
      (row, col) => alpha * m(row)(col)
    )
  }

  // given two square matrices of the same dimension dim,
  // create a new MATRIX which corresponds to the difference (a - b)
  // of the two input matrices.
  def matrixSubtract(a: MATRIX, b: MATRIX): MATRIX = {
    matrixAdd(a, matrixScale(-1.0, b))
  }

  // given two square matrices of the same dimension dim,
  // create a new MATRIX which corresponds to the product (a times b)
  // of the two input matrices.
  def matrixMultiply(a: MATRIX, b: MATRIX): MATRIX = {
    assert(dimension(a) == dimension(b))
    matrixTabulate(
      dimension(a),
      (row, col) =>
        (0 until dimension(a))
          .foldLeft(0.0)((acc: Double, k: Int) => acc + a(row)(k) * b(k)(col))
    )
  }

  def matrixTranspose(m: MATRIX): MATRIX = {
    matrixTabulate(dimension(m), (row, col) => m(col)(row))
  }

  def matrixPower(m: MATRIX, p: Int): MATRIX = {
    if (p == 0)
      matrixIdentity(dimension(m))
    else if (p == 1)
      m
    else if (p % 2 == 0) { // even
      val tmp = matrixPower(m, p / 2)
      matrixMultiply(tmp, tmp)
    } else
      matrixMultiply(m, matrixPower(m, p - 1))
  }

  def matrixAlmostEqual(a: MATRIX, b: MATRIX, epsilon: Double): Boolean = {
    ???
  }

  def threeConsecutiveFibonacci(n: Int): (Int, Int, Int) = {
    ???
  }

  def main(argv: Array[String]): Unit = {
    val m = Vector(
      Vector(1.0, 2.0, 3.0),
      Vector(2.0, 3.0, 5.0),
      Vector(2.0, -1.0, 0.0)
    )
    val p = Vector(
      Vector(2.0, 2.0, 3.0),
      Vector(-2.0, 1.0, 0.0),
      Vector(-2.0, -1.0, 0.0)
    )
    println(matrixToString(m))
    println(matrixToString(matrixRandom(4)))
    println(matrixToString(matrixIdentity(4)))
    println(matrixToString(matrixAdd(m, m)))
    println(matrixToString(matrixSubtract(m, m)))
    println(matrixToString(matrixMultiply(m, p)))
    println(matrixToString(matrixMultiply(p, matrixIdentity(3))))
  }
}
