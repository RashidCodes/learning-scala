// this function takes as an argument, the type of the literal "a"
def identity[A](a: A): A = a

/*
scala> identity[Double](2.715)
val res11: Double = 2.715

scala> var rashid: String = identity[String]("Hello world!")
var rashid: String = Hello world!
*/
