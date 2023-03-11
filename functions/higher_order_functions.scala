/* HIGHER ORDER FUNCTIONS 
 * Functions that accept other functions as parameters and/or use functions as return values are known as higher-order functions 
*/

def double(x: Int): Int = x * 2;


// create a higher order function ( reminds me of decorators in python)

var myDouble: Int => Int = double;

var doubleTwo: Int = myDouble({var a = 10; a+5;});
println(s"Double of ${{var a = 10; a+5;}} is ${doubleTwo}")


// you can also create a higher order function like this 

var mySecondDouble: Int => Int = double _;
var doubleThree: Int = mySecondDouble({var a = 10; a + 50; })
println(s"Double of ${{var a = 10; a + 50; }} is $doubleThree")


/* Functions with no inputs */
def logStart() = "=" * 50 + "\nStarting NOW\n" + "=" * 50

var start: () => String = logStart;

println( start() )


/* More higher order functions */

def safeString(s: String, f: String => String) = {
  if (s != null) f(s) else s
};

def reverser(s: String) = s.reverse;

// returns null
println(safeString(null, reverser))

// reverses the string 
println(safeString("rashid is awesome", reverser))



