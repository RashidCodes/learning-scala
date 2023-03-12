# Learning Scala

## Useful Resources
https://docs.scala-lang.org/tour/unified-types.html#

## The Cons Operator

Scala supports use of the *cons*(short for construct) operator to build lists. Using `Nil` as a foundation and the right-associative cons operator `::` for binding elements, you can build a list without using the traditional `List(...)``` format.

<blockquote>In right-associative notation, triggered with operators end with a colon (:), operators are invoked on the entity to their immediate <b>right</b></blockquote>

```scala 
val numbers = 1 :: 2 :: 3 :: Nil
```

`::` is simply a method in `List`. It takes a single value that becomes the head of a new list, its tail pointing to the list on which `::` was called. Checkout this example 

```scala 
// set the head of first to 1
// NB: :: is left-associative in this instance because it's a method on Nil
var first = Nil.::(1)
```
