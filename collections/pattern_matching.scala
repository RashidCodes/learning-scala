/* Pattern Matching */

val statuses = List(500, 404);

val msg1 = statuses.head match {
  case x if x < 500 => "okay"
  case _ => "whoah, an error"
}

/* value binding with a guard */
val msg2 = statuses match {
  case x if x.contains(500) => "has error"
  case _ => "okay"
}

/* To match the entire collection, use a new collection as
 * your pattern 
 */

val msg3 = statuses match {
  case List(404, 500) => "not found & error"
  case List(500, 404) => "error & not found"
  case List(200, 200) => "okay"
  case _ => "not sure what happened"
}


/* You can use value binding to bind value to some or all elements of a collection in your pattern guard */
val msg = statuses match {
  case List(500, x) => s"Error followed by $x"
  case List(e, x) => s"$e was followed by $x"
}


/* List are decomposable into their head element and their tail. In the same way, as patterns they
 * can be matched on their head and tail elements
 */
val head = List('r', 'g', 'b') match {
  case x :: xs => x
  case Nil => ' '
}


/* Tuples, while not officially collections, als support pattern matching and value binding */
val code = ('h', 204, true) match {
  case(_, _, false) => 501
  case('c', _, true) => 302
  case('h', x, true) => x
  case(c, x, true) => {
    println(s"Did not expected code $c")
    x
  }
}
