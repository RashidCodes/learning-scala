// RECURSIVE FUNCTIONS 
// The Scala compiler can optimize some recurisve functions with tail-recursion
// so that recursive calls do not use additional stack space.


// Mark a function as intended for tail recursion optimisation 
// this will not work because the recursive function is not the 
// recursive call is NOT the last item of the function 
// @annotation.tailrec
// def power(x: Int, n: Int): Long = {
//   if (n >= 1) x * power(x, n-1) 
//   else 1 
// }

// let's fix it 
// notice how we provided t with a default value
@annotation.tailrec
def power(x: Int, n: Int, t: Int = 1): Int = {
  if (n < 1) t
  else power(x, n-1, x*t)
}
