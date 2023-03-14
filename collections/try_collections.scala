/* util.Try collection turns error handling into error management 
 *
 */
def nextError = util.Try { 1 / util.Random.nextInt(2) }

val a = nextError;
val b = nextError;

