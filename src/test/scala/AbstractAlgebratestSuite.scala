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

import org.scalatest.funsuite.AnyFunSuite

class AbstractAlgebraTestSuite extends AnyFunSuite {

  import AbstractAlgebra._

  test("groupByStringSize") {
    ???
  }

  test("groupByMinElement") {
    ???
  }

  test("groupByModulus") {
    assert(groupByModulus(0, 10, 3) == Map(0 -> Seq(0, 3, 6, 9),
                                           1 -> Seq(1, 4, 7, 10),
                                           2 -> Seq(2, 5, 8)))
  }

  test("matrixAdd"){
    ???
  }

  test("matrixSubtract"){
    ???
  }

  test("matrixMultiply"){
    ???
  }

  test("complexAdd"){
    ???
  }

  test("complexSubtract"){
    ???
  }

  test("complexMultiply"){
    ???
  }

  test("i*i = -1"){
    ??? // how can you test that i*i == -1
  }

  test("matrix addition commutative"){
    ??? // use randomMatrix()
  }

  test("matrix addition associative"){
    ??? // use randomMatrix()
  }

  test("matrix multiplication associative"){
    ???  // use randomMatrix()
  }

  test("complex multiplication commutative"){
    ???
  }
}
