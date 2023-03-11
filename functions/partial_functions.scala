/* Partial functions
 *
 * A partial function, as opposed to a total function, only accepts a partial amount of all possible input values
 */

val statusHandler: Int => String = {
  case 200 => "Okay";
  case 400 => "Your Error";
  case 500 => "Our Error";
}


println(statusHandler(200))

println(statusHandler(400))

println(statusHandler(401))
