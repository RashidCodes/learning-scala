// Functions 
// In functional programming, a pure function is one that:
//  Has one or more input parameters
//  Performs calculations using only the input parameters
//  Returns a value 
//  Always returns the same value for the same input
//  Does not use or affect any data outside the function
//  Is not affected by any data outside the function
//

// input-less function
// def hi = "hi"

def hello: String = "hello"

// create a multiplier function 
def multiplier(x: Int, y:Int): Int = { x * y }

// using the return keyword 
def safeTrim(s: String): String = { 

  /**
   * Returns the input string without leading or trailing 
   * whitespace, or null if the input string isn ull.
   *
   * @param s the input string trim, or null
   */

  if (s == null) return null 
  s.trim()
}


def formatEuro(amt: Double): String = f"E$amt%.2f"

// passing expressions as arguments  to functions 
formatEuro { val rate = 1.32; 0.235 + 0.7123 + rate * 5.32 }

// input-less functions (alternative way)
def hi(): String = "hi"

// calling functions with default arguments 
def greet(name: String, prefix: String = ""): String = s"$prefix$name"
