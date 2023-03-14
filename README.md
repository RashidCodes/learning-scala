# Learning Scala

## Useful Resources
https://docs.scala-lang.org/tour/unified-types.html#

## The Cons Operator

Scala supports use of the *cons*(short for construct) operator to build lists. Using `Nil` as a foundation and the right-associative cons operator `::` for binding elements, you can build a list without using the traditional `List(...)` format.

<blockquote>In right-associative notation, triggered with operators that end with a colon (:), operators are invoked on the entity to their immediate <b>right</b></blockquote>


## Data Structures 
Lists, Sets, Maps, Vectors, Buffers, etc.


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
 * fold might not work here
*/

val included = List(46, 19, 92).foldLeft(false) { (a, i) => if (a) a else (i == 19) }
```

## Mutable types 

- `collecion.mutable.Set`
- `collecion.mutable.Buffer`
- `collection.multable.Map`
- `newBuilder`

## Arrays 
Fixed size, mutable, indexed collection. It's not officially a collection, because it isn't in the `scala.collections` package and doesn't extend from the root `Iterable` type (although it has all of the `Iterable` operations like `map` and `filter`). I don't recommend using Arrays in regular practice unless you need it for JVM code. There are many other fine sequences that can be used instead.

```scala 
val colors = Array("red", "green", "blue")

// the Array is mutable 
colors(0) = "purple"
```

## Vector 

A list backed by `Array` instance for indexed access. As an indexed sequence, you can access items in a Vector directly by their index. By contrast, accessing the *nth* item of a `List` (a linked list) requires *n-1* steps from the head of its list.

```scala 
val scalaVector: Vector[Int] = Vector(1, 2, 3, 4);
```

## Streams

The `Stream` type is a lazy collection, generated from one or more starting elements and a recursive function. **Elements are added to the collection only when they are accessed for the first time**, in contrast to other immutable collections that receive 100% of their contents at instantiation time. Streams are deprecated for `LazyList` in newer versions of Scala.

```scala
// assume that inc(head + 1) is the tail of the stream
def inc(head: Int): Stream[Int] = head #:: inc(head + 1);

// take some elements 
inc(10).take(10).toList
```

Streams can be terminated with `Stream.Empty`


## Option Collections 
The `Option` represents the presence or absence of a single value. This potentially missing value can thus be wrapped in an `Option` collection and have its potential absence clearly advertised.

```scala
/* checkout the return type 
 * Option uses the following types in its implementation: None, Some
 */
def divide(amt: Double, divisor: Double): Option[Double] = {
	if (diviser == 0 ) then None
	else Option(amt/divisor)
}
``` 



# Object Oriented Scala 
The `java.lang.Object` class is the root of all instances in the JVM, including Scala, and is essentially equivalent to the Scala root type `Any`. `AnyRef` is the root of all instantiable types. Thus, invoking `toString` on our `User` class resulted in a call to its parent, `AnyRef`, then to its parent, `Any`, which is the same as `java.lang.Object` and where the `toString` method is located.

Let's take a few examples

```scala 
class User(n: String) {
   // class parameter
   val name: String = n;
   def greet: String = s"Hello from $name";
   override def toString = s"User($name)";
}
```

```scala 
class User(val name: String) {
   // you can use $name directly now 
   def greet: String = s"Hello from $name";
   override def toString = s"User($name)";
}
```

## Inheritance 

A class can extend another with the `extends` keyword. When extending classes that extend classes which take parameteres, you'll need to make sure the parameters are included in the classes' definition. The class identified following the `extends` keyword should have its own set of input parameters as necessary.

```scala 

class Car(val make: String, var reserved: Boolean) {
   def reserve(r: Boolean): Unit = { reserved = r };
};

class Lotus(val color: String, reserved: Boolean) extends Car("Lotus", reserved);

val l = new Lotus("Silver", false);

println(s"Requested a ${l.color} ${l.make}")

```
