import scala.util.Random
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation
// files (the "Software"), to deal in the Software without restriction,
// including without limitation the rights to use, copy, modify, merge,
// publish, distribute, sublicense, and/or sell copies of the Software,
// and to permit persons to whom the Software is furnished to do so,
// subject to the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

object AbstractAlgebra {
  // TASK: take a sequence of strings and return the equivalence
  //   classes, (as a Map[Int,String]) by length.  I.e., each
  //   equivalence class should contains strings of the same length,
  //   and there should be one equivalence class for each positive
  //   length.  Omitting equivalence classes of size 0.
  def groupByStringSize(strs: Seq[String]): Map[Int, Seq[String]] = {
    // ???
    strs.groupBy(_.size)
  }

  // TASK: given a sequence of sets of integers, partition them by
  //   minimum element
  def groupByMinElement(sets: Seq[Set[Int]]): Map[Int, Seq[Set[Int]]] = {
    sets.groupBy(_.min)
  }

  // TASK: given the lower and upper bounds (inclusive) of a sequence
  //   of integers, and an integer n,
  //   partition the integers into equivalence classes modulo-n
  def groupByModulus(lower: Int, upper: Int, n: Int): Map[Int, Seq[Int]] = {
    // ???
    (lower to upper).groupBy(x => x % n)
  }

  type MATRIX[T] = Vector[Vector[T]]

  def matrixTabulate(n: Int, f: (Int, Int) => Int): MATRIX[Int] = {
    for {i <- (0 until n).toVector
         } yield for {j <- (0 until n).toVector
                      } yield f(i, j)
  }

  // TASK: matrix identity
  def matrixIdentity(n: Int): MATRIX[Int] = {
    matrixTabulate(n, (i, j) => if (i == j) 1 else 0)
  }

  // TASK: matrix add
  def matrixAdd(m: MATRIX[Int], n: MATRIX[Int]): MATRIX[Int] = {
    matrixTabulate(m.size, (i, j) => m(i)(j) + n(i)(j))
  }

  def matrixScale(s: Int, m: MATRIX[Int]): MATRIX[Int] = {
    matrixTabulate(m.size, (i, j) => s * m(i)(j))
  }

  // TASK: matrix subtract in terms of matrixScale
  def matrixSubtract(m: MATRIX[Int], n: MATRIX[Int]): MATRIX[Int] = {
    matrixAdd(m, matrixScale(-1, n))
  }

  // TASK: matrix multiply
  def matrixMultiply(m: MATRIX[Int], n: MATRIX[Int]): MATRIX[Int] = {
    matrixTabulate(m.size,
                   (i, j) => (for {k <- m.indices.toVector
                                   } yield m(i)(k) * n(k)(j)).sum)
  }

  // TASK: power of matrix, use the fast monoid multiplication
  def matrixPower(m: MATRIX[Int], n: Int): MATRIX[Int] = {
    assert(n >= 0)
    if (n == 0)
      matrixIdentity(n)
    else if (n == 1)
      m
    else if (n % 2 == 1)
      matrixMultiply(m, matrixPower(m, n - 1))
    else {
      val tmp = matrixPower(m, n / 2)
      matrixMultiply(tmp, tmp)
    }
  }

  def complexToMatrix(z: (Int, Int)): MATRIX[Int] = {
    val (zr, zi) = z
    Vector(Vector(zr, -zi),
           Vector(zi, zr))
  }

  def matrixToComplex(m: MATRIX[Int]): (Int, Int) = {
    assert(m.size == 2)
    val Vector(Vector(zr, _),
               Vector(zi, _)) = m
    (zr, zi)
  }

  // TASK: add two complex numbers by using MatrixAdd
  def complexAdd(a: (Int, Int), b: (Int, Int)): (Int, Int) = {
    matrixToComplex(matrixAdd(complexToMatrix(a),
                              complexToMatrix(b)))
  }

  // TASK: subtract subtract two complex numbers by using matrixSubtract
  def complexSubtract(a: (Int, Int), b: (Int, Int)): (Int, Int) = {
    matrixToComplex(matrixSubtract(complexToMatrix(a),
                                   complexToMatrix(b)))
  }

  // TASK: multiply two complex numbers by using matrixMultiply
  def complexMultiply(a: (Int, Int), b: (Int, Int)): (Int, Int) = {
    matrixToComplex(matrixMultiply(complexToMatrix(a),
                                   complexToMatrix(b)))
  }

  // TASK: generate a random n x n matrix.  i.e. an nxn matrix
  //   with random integers.   Limit the integers to -100 <= k <= 100
  def randomMatrix(n: Int): MATRIX[Int] = {
    assert(n > 0) // only consider matrices of positive size
    val rand = new Random()
    matrixTabulate(n, (_, _) => rand.between(-100, 101)) // -10 inclusive, 11 exclusive
  }
}
