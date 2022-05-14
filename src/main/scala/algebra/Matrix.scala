package algebra

object Matrix {
  type MATRIX = Vector[Vector[Double]]

  def dimension(m: MATRIX): Int = {
    ???
  }

  def matrixIdentity(dim: Int): MATRIX = {
    ???
  }

  def matrixAdd(a: MATRIX, b: MATRIX): MATRIX = {
    ???
  }

  def matrixScale(alpha: Double, m: MATRIX): MATRIX = {
    ???
  }

  def matrixSubtract(a: MATRIX, b: MATRIX): MATRIX = {
    ???
  }

  def matrixMultiply(a: MATRIX, b: MATRIX): MATRIX = {
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
}
