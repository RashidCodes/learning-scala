// There are times when you have logic that needs to be repeated inside a method, but 
// would not benefit from being extrapolated to an external method. In these cases,
// defining an internal function inside another function, to only be used in that function, may 
// be worthwhile.

def max(a: Int, b: Int, c:Int): Int = {
  def max(x: Int, y: Int): Int = if (x > y) x else y;
  max(a, max(b, c))
}
