# Learning Scala

## Useful Resources
https://docs.scala-lang.org/tour/unified-types.html#

## The Cons Operator

Scala supports use of the *cons*(short for construct) operator to build lists. Using `Nil` as a foundation and the right-associative cons operator `::` for binding elements, you can build a list without using the traditional `List(...)` format.

<blockquote>In right-associative notation, triggered with operators that end with a colon (:), operators are invoked on the entity to their immediate <b>right</b></blockquote>

```scala 
val numbers = 1 :: 2 :: 3 :: Nil
```

`::` is simply a method in `List`. It takes a single value that becomes the head of a new list, its tail pointing to the list on which `::` was called. Checkout this example 

```scala 
// set the head of first to 1
// NB: :: is left-associative in this instance because it's a method on Nil
var first = Nil.::(1)
```

## List Arithmetic
In general, it is best to operate on the front of a list, not its end.

```scala 
/* corollary operations for ::, take, and drop. Try to use them sparingly */
val appended = List(1, 2, 3, 4) +: 5
val suffix = appended takeRight 3 
val middle = suffix dropRight 2
```

## List Mapping Operators 

```scala 
List(0, 1, 0) collect { case 1 => "ok" }
List("milk", "tea") map (_.toUpperCase)
```

## List Reduction

Interestingly, the difference between the left/right directional varieties of each operation e.g. `foldLeft`, and the non-directional variety, e.g. `fold`, may be more significant than the differences between the three folding operations. For one thing, `fold`, `reduce`, and `scan` are all limited to returning a value of the same type as the list of elements, while the left/right varities of each operation support unique return types. Thus you could implement the `forall` Boolean operation on a list of integers with `foldLeft` but would not be able to do so with `fold`.

```scala 

/* notice the return type of function is boolean whereas the list contains Ints 
/* fold might not work here
val included = List(46, 19, 92).foldLeft(false) { (a, i) => if (a) a else (i == 19) }

