/* Monadic Collections 
 *
 * Option 
 * ======
 * A collection of one element which may or may not be present
 */

var x: String = "Indeed";
val a = Option(x);
x = null;
val b = Option(x);


/* Option provides a clear warning to callers that its value is only potential, and ensures
 * that its results will need to be carefully handled. Checkout its use with collections below
 */
def divide(amt: Double, divisor: Double): Option[Double] = {
  if (divisor == 0) None
  else Option(amt / divisor)
}

val legit = divide(5, 2);
val illegit = divide(3, 0);



val odds: List[Int] = 1 :: 3 :: 5 :: Nil

/* Using options with collections */
val firstOdd = odds.headOption
val evens = odds filter (_ % 2 == 0)
val firstEven = evens.headOption

/* Another use of options in collections is in the find operation, a combination of filter and the headOption 
 * that returns the first element that matches a predicate function
 */

val words = List("risible", "scavenger", "gist");
val uppercase = words find (w => w == w.toUpperCase);
val lowercase = words find (w => w == w.toLowerCase);


/* A great example of the Option as a monadic collection, providing a single unit that can be executed
 * safely (and type-safely) in a chain of operations 
 */

val filtered = lowercase filter (_ endsWith "ible") map (_.toUpperCase);
val exactSize = filtered filter (_.size > 15) map (_.size)



/* Extracting the value of an Option */

// type safe 
def nextOption = if (util.Random.nextInt > 0) Some(1) else None;

val r = nextOption.fold(-1)(x => x);
val s = nextOption.fold(-1)(x => x);
val t = nextOption getOrElse 5;
val q = nextOption getOrElse { println("error"); -1 };

