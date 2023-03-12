/* The recursive function is used to generate a new Stream and derive
 * the new head element each time. The most important part is defining the head
 * value of your new stream.
 */

def inc(head: Int): Stream[Int] = head #:: inc(head+1);

// take a few values 
inc(10).take(10).toList

/* creating a bounded stream */
def to(head: Char, end: Char): Stream[Char] = (head > end) match {
  case true => Stream.empty
  case false => head #:: to((head+1).toChar, end)
}

val hexChars = to('A', 'F').take(20).toList
