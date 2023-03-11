/* Using by-name parameters */

def doubles(x: => Int) = {
  println("Now doubling " + x);
  x * 2;
}

/* a function that returns an int */
def f(i: Int): Int = { println(s"Hello from f($i)"); i };


/* the x by-name parameter is accessed here just like a normal by-value parameter 
 * ... but when you invoke it with a function value, that function value will get
 * invoked inside the doubles function
 * Because the double method refers to x param twice, the "Hello" message gets 
 * invoked twice
 */

doubles(f(5))
