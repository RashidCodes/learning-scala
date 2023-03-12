/* Lists in Scala
 *
 * Surprisingly, lists are immutable in Scala. How cool interesting is that!?
 */

val numbers = List(32, 95, 24, 21, 17)
val colors = List("red", "green", "blue")

/* the size method is available on all collections */
println(s"I have ${colors.size} colors: $colors")

/* Lists are zero-based */
println(s"First element: ${colors(0)}")

/* head and tail methods */
println(s"Head: ${colors.head}")

println(s"Tail: ${colors.tail}")


/* higher order functions */
// Foreach - Similar to foreach in JS
colors.foreach( (c: String) => { println(c) } )

// Map - returns a list 
var stringSizes: List[Int] = colors.map( (c: String) => c.size)

// Reduce 
var total: Int = numbers.reduce( (a: Int, b: Int) => a + b);


var primes = List(2, 3, 5, 7, 11, 13);

// traversing a list recursively 
// def visit(i: List[Int]): String = { if (!i.isEmpty) { print(s"${i.head}" + ", ") } else return ""; visit(i.tail) };

println(visit(primes))

// comparing to Nil instead of using isEmpty 
def visit(i: List[Int]): String = { if (i != Nil) { print(s"${i.head}" + ", ") } else return ""; visit(i.tail) }; 

