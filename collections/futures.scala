import concurrent.ExecutionContext.Implicits.global
import concurrent.Future


def nextFtr(i: Int = 0) = Future {
  def rand(x: Int) = util.Random.nextInt(x);

  Thread.sleep(rand(5000));
  if (rand(3) > 0) { i + 1 } else throw new Exception;
}

/* chaining futures */
// if the first is unsuccessful, the second is invoked.
nextFtr(1) fallbackTo nextFtr(2);

/* flatMap: Chains the second future to the first and returns
 * and new overall future. If the first is successful, its
 * return value will be used to invoke the second
 */

nextFtr(1) flatMap nextFtr();

