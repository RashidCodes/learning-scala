/* Partially Applied Functions and Currying
 *
 * What if you wanted to reuse a function invocation and retain some of the parameters to avoid typing them again 
 */

def factorOf(x: Int, y: Int) = y % x == 0;


/* type is inferred with the help of the placeholder */
val f = factorOf _

println(s"Using factor: ${{ f(7, 20) }}")


/* Reuse the factorOf function */
val multipleOf3 = factorOf(3, _:Int)

/* You don't need x because it's already defined */

println(s"Using multipleOf3: ${{multipleOf3(78)}}")


/* Currying 
 *
 * A cleaner way to partially apply functions is to use functions with multiple parameter lists
 */

def cleanFactorOf3(x: Int)(y:Int) = y % x == 0;

var cleanMultipleOf3 = cleanFactorOf3(2) _

println(s"Using cleanMultipleOf3: ${{cleanMultipleOf3(78)}}")

