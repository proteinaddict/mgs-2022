package functions

import scala.math.sqrt
import cats.instances.int
import scala.collection.View
object QuadraticFormula {

  def discriminant(a:Int, b:Int, c:Int): Int = {
    b*b - 4*a*c
  }
  def quadraticFormula(a: Int, b: Int, c: Int): List[Double] = {
    val d = discriminant(a,b,c)
    // if there is 1 root, return it as a singleton list
    if ( d == 0)
      List( -b / (2.0*a))
    // if there are no roots, return an empty list
    else if (d < 0)
      List()
    // if there are 2 roots, return a list of them in increasing order
    else if (a < 0)
      List((-b + sqrt(d)) / (2.0 * a),
           (-b - sqrt(d)) / (2.0 * a))
    else
      List((-b - sqrt(d)) / (2.0 * a),
           (-b + sqrt(d)) / (2.0 * a))
  }

  def main(argv: Array[String]): Unit = {
    println("Hello this is main of QuadraticFormula")
    println(quadraticFormula(1, 2, -3))
    println(quadraticFormula(-1, 3, 7))
  }
}
