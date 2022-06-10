package functions

object `suffering` {
  
 def diophant(a: Int, b:Int, c:Int, n: Int) = {
    for {
        x <- (0 to n) 
        y <- (0 to n)
        if a*x + b*y == c
 } yield (x,y)
 }

def main(argv: Array[String]): Unit = {
     println("These ones work! " + diophant(2,4,28,100))
 }
}