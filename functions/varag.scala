// Varag is a function parameter that can match zero or more arguments from the caller 

def sum(items: Int*): Int = {
  var total: Int = 0;
  for (i <- items) total += i;
  return total
}
