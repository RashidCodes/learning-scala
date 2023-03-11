/* Function literals
 *
 * Function literals are working functions that lack a name. Reminds me of lambdas in python 
 *
 */

val doubler = (x: Int) => x * 2;
var doubled = doubler(22);

/* Writing a function literal */
val greeter = (name: String) => s"Hello, $name"

println(greeter("rashid"))


val maximise = (a: Int, b: Int) => if (a > b) a else b


def safeStringOp(s: String, f: String => String): String = {
  if (s != null) f(s)
  else s
}

def combination(x: Int, y: Int, f: (Int, Int) => Int): Int = f(x,y);

/* using the placeholder syntax
 * The placeholder syntax is valid here because the input parameter is only used once
 * and the literal's type has an external explicit definition
 */

println( safeStringOp("Ready", _.reverse) )

var res = combination(2, 3,  _ * _)


def tripleOp(a: Int, b:Int, c:Int, f: (Int, Int, Int) => Int) = f(a, b, c)

println(s"Triple Op = ${tripleOp(2, 3, 4, _.+(_) - _)}")

def tripleOpUpgraded[A,B](a: A, b: A, c: A, f: (A, A, A) => B) = f(a, b, c);

println(tripleOpUpgraded[Int, Int](23, 92, 14, _ * _ + _))

/* let's use some special types */
println(tripleOpUpgraded[Int, Boolean](93, 92, 14, _ > _ + _))




