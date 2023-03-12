/* Reducing lists with Higher order functions
 * ============================================
 *
 * Witness the ingenious use of higher order functions and placeholders. These higher-order functions to reduce a list
 * based on the input function are popularly known as list-folding operations, because the function of reducing a list
 * is better known as a fold.
 *
 */

def contains(x: Int, l: List[Int]): Boolean = {
  var a: Boolean = false;
  for (i <- l) { if (!a) a = (i == x) };
  a
}


def boolReduce(l: List[Int], start: Boolean)(f: (Boolean, Int) => Boolean): Boolean = {
  var a = start
  for (i <- l) a = f(a, i);
  a
}


def reduceOp[A,B](l: List[A], start: B)(f: (B,A) => B): B = {
  var a = start;
  for (i <- l) a = f(a, i);
  a
}


/* the placeholder syntax can be used here because the parameters are each accessed only once
 * in the function body
 */
var answer = reduceOp(List(11.3, 23.5, 7.2), 0.0)(_ + _)
val included = reduceOp(List(46, 19, 92), false){ (a, i) => if (a) a else (i == 19) }
