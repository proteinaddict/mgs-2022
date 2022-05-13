package functions

object FastPower {

  // TASK:
  //     Implement two functions named power, one which accepts
  //      and Int base and Int exponent, and a second which accepts
  //      a Double base and Int exponent.  The second function should
  //      also support a negative exponent, however the first one cannot.
  //      Why can it not?
  //
  def power(b: Int, n: Int): Int = {
    ???
  }

  def power(b: Double, n: Int): Double = {
    ???
  }

  // TASK:
  //      Implement String concatenation using the same model as the
  //      power function.  The function should accept a String, and an
  //      exponent n >= 0.  What should it return if n=0?
  def power(b: String, n: Int): String = {
    ???
  }

  // 6. TASK:
  //      Implement List concatenation using the same concept.  What
  //      should the function return when n=0?
  def power[T](b: List[T], n: Int): List[T] = {
    ???
  }

  def main(argv: Array[String]): Unit = {

  }
}
