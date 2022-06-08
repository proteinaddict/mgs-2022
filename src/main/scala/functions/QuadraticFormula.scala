package functions

import scala.math.sqrt

object QuadraticFormula {

def discriminant(a: Int, b: Int, c: Int) = {
  (b * b - 4 * a * c) 
}

 def quadraticFormula(a: Int, b: Int, c: Int): List[Double] = {
   val d = discriminant(a,b,c)
    if (d == 0)
      List(-b /(2 * a))
    else if (d > 0)
      List(
      (-b - sqrt(d))/(2 * a),
      (-b + sqrt(d))/(2 * a)
      )
    else
      List()

  }


  // TASK:
  //    Update the formula to compute the discriminant,
  //    and detect whether there are zero, one, or two real roots.
  //    refactor the function to return a list of length 0, 1, or 2
  //    accordingly.  If there are two roots return them in increasing
  //    order.

  // TASK:
  //    Do your tests still work?  If not, do you need to
  //    update your tests, or do you need to update the function?
  //    Make sure your tests are up to date, and that they test the
  //    new features you implemented in previous step.

  def main(argv: Array[String]): Unit = {
    println("Hello this is main of QuadraticFormula")
    println(quadraticFormula(0, 2, -3).sorted)
    println(quadraticFormula(0, 3, 7).sorted)
  }
}
