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

object SetsAndFunctions {
    // 1. write a function to determine whether a sequence of pairs designates a relation 
    def relation(as:Set[Int], bs:Set[Int], cs:Seq[(Int,Int)]):Boolean = {
        cs.forall{pair => as.contains(pair._1) && bs.contains(pair._2)}
    }

    // 2. write a function to determine whether a sequence of pairs designates a function 
    // 3. decide whether such a function is injective, surjective, bijective.
    // 4. compute the union, intersection, and complement
    // 5. implement a subset function and an equivalence function based on your subset function. 
    // 6. partition a set into equivalence classes
    // 7. generalize to partition based on equivalence of probe function.
    // 8. rewrite step 5 in terms of 6.

  def main(argv:Array[String]):Unit = {
    println("Hello this is main of SetsAndFunctions")
  }
}
