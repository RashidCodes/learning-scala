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
   // this initialization is not necessary in Scala 3
   val name: String = n;
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

## Abstract Classes

Thanks to **polymorphism**, a value with the type of the abstract class can actually point to an instance of one of its nonabstract, and invoke methods that actually end up being invoked on the subclass.

```scala
abstract class Car {
   val year: Int
   val automatic: Boolean = true
   def color: String 
}

// abstract classes are not instantiable 
new Car() // error
```

Let's extend the abstract class to make it useful
```scala 
class RedMini(val year: Int) extends Car {
   def color = "Red"
}

val m: Car = new RedMini(2005)
```

Check this out, scala is one interesting language. You can implement a parameter-free method with a variable/value 

```scala 
// remember color used to be a parameter-free method?
class Mini(val year: Int, val color: String) extends Car

val redMini: Car = new Mini(2005, "Red")a
println(s"Got a ${redMini.color} Mini")
```

## Anonymous Classes
A less formal way of implementing a parent class

```scala 
abstract class Listener { def trigger: Unit };

val myListener = new Lister {
   def trigger = { println(s"Trigger at ${new java.util.Date}") }
}

myListener.trigger
```

Let's take a look at another example 

```scala 

abstract class Listener = { def trigger: Unit };

class Listening {
   var listener: Listener = null;
   def register(l: Listener) = { listener = l };
   def sendNotification() { listener.trigger };
};

val notification = new Listening();

// register a listener 
notification.register(new Listener {
   def trigger = println(s"Trigger at ${new java.util.Date}")
})

// send the notification 
notification.sendNotification()
```


## Overloaded Methods 

An overloaded method is a strategy for providing choices to callers. We learned this from Solidity/Java. Overloading may be a useful feature but many Scala developers prefer to use default value parameters versus overloading because overloading can be quite verbose.

```scala 
class Printer(msg: String) {
   def print(s: String): Unit = println(s"$msg: $s");
   def print(l: Seq[String]): Unit = print(l.mkString(", "))
}

new Printer("Today's Report").print("Foggy" :: "Rainy" :: "Hot" :: Nil);
new Printer("Today's Report").print("You're going home!")
```


# Apply methods 
Methods named "apply"", sometimes referred to as a default method or an injector method, can be invoked without the method name. The apply method is essentialy a shortcut, providing functionality that can be triggered using parentheses but without method name.


```scala 

class Multiplier(factor: Int) {
   // default method 
   def apply(input: Int) = input * factor;
}

val trippleMe = new Muliplier(3)
val trippled = trippleMe.apply(10);
val trippled2 = tripple(10);a
```


## Lazy Values
Lazy values are only created the first time they are instantiated. They are popularly used to store information such as file-based properties, open database connections, and other immutable data that should only be initialized if it is really necessary. By initializing this data in a lazy val's expression, you can ensure that it will only operate if the lazy val is accessed at least once in the class instance's lifetime.

```scala 
class RandomPoint {
   // this is executed every time an instance is created
   val x = { println("creating x"); util.Random.nextInt }

   // executed the first time it's invoked
   lazy val y = { println("now y"); util.Random.nextInt }
};

val p = new RandomPoint
println(s"Location is ${p.x}, ${p.y}")
println(s"Location is ${p.x}, ${p.y}")

```

## Packaging 
After creating your own classes, at some point you'll start organizing them to prevent namespace cluttering. Scala source files should be stored in directoies that match their package. For example, a "DataUtilities" class in the "com.netflix.utilities" package should be stored under */com/netflix/utilities/DataUtilities.scala*. The Scala compiler will store the generated *.class* files (the standard binary format for JVM-executable code) in a directory structure that matches the package.


## Privacy Controls
By default, Scala does not add privacy controls. Any class you write will be instantiable and its fields and methods accessible by any other code. If you do have some reason to add privacy controls, such as mutable state that should only be handled inside the class, you can add them on a field and method basis in your class.

## Privacy Access Modifiers 
Use privacy access modifiers for more fine-grained control over your class' members. Access modifiers can be specified in addition to `private` or `protected`.

```scala 
// limit a field or member to a single class
private[this];

// limit a field or member to the orielly package only
private[orielly];
```

They can even be used with classes 
```scala 
private[oreilly] class Config {
   var url = "http://127.0.0.1/8005"
}
```


## Final and Sealed Classes
The `protected` and `private` access controls and their modifiers can limit access to a class or its members overall or based on location. However, they lack the ability to restrict creating subclasses!

### Final Classes 
A class marked as `Final` cannot be subclassed.

```scala 
final class FinalClass (var a: Int){
  def showA: Unit = { println(s"($a)") }
}

// this fails
class B extends FinalClass(12);
```

## Sealed classes 
If final classes are too restrictive for you, then consider a *sealed* class instead. Sealed classes restrict the subclass of a class to being located in the same file as the parent class. 
The `Option` class is both *abstract* and *sealed*, and implemented with the proper assumption that it will only ever have two subclasses. Sealed classes are a useful way to implement an abstract parent class that "knows" and refers to specific subclasses.


```scala 
sealed class SealedClass (val name: String, val age: Int){
  def showName: String = s"Hello I'm $name and I've lived on earth for ${age} years"
}

class SubclassedSealed(val height: String = "6'4") extends SealedClass("rashid", 26) {
  def showHeight: String = s"I'm ${height} tall";
}

val sealedClass: SealedClass = SealedClass(name = "Rashid", age = 26);
val subclassed: SubclassedSealed = SubclassedSealed();

println(subclassed.showHeight);
println(sealedClass.showName);
```

## Traits 

A trait is a kind of class that **enables multiple inheritance**. Classes, case classes, objects, and traits can all extend no more than one class but can extend multiple traits at the same time. Unlike other types, however, **traits cannot be instantiated**.

Traits, like objects, **cannot** take class parameters. Unlike objects, however, traits can take type parameters, which can help to make them highly reusable.

```scala 
trait HtmlUtils {
   def removeMarkup(input: String) = {
      input 
         .replaceAll("""</?\w[^>]*>""", "")
         .replaceAll("""<.*>""", "")
   }
};

class Page(val s: String) extends HtmlUtils {
   def asPlainText = removeMarkup(s)
};

new Page("<html><body><h1>Introduction</h1></body></html>").asPlainText;
```

### Traits come after parent class
If you're extending a class **and** one or more traits, you will need to extend the class before you can add the traits using the `with` keyword. A parent class if specified must always come before any parent traits. It's important to understand how **linearization** shapes the hierarchy of any class that extends traits. Read more about traits in the sbt-project.

### Self types 
A *self type* is a trait annotation that asserts that the trait must be mixed with a specific type, or its subtype, when it is added to a class. **A trait with a self type cannot be added to a class that does not extend the specific type**.

**How are self types used?**
A popular use of self types is to add functionality with traits to classes that require input parameters. A trait cannot easily extend a class that takes input parameters, because the trait itself cannot take input parameters.

However, **it can declare itself to be a subtype of that parent class** with a self type and then add its functionality. Go [selfTypes.scala](https://github.com/RashidCodes/learning-scala/blob/main/packages/hello-world/src/main/scala/com/oreilly/selfTypes.scala) for an example.

### Instantiation with Traits
An alternate method for using traits is to **add them to a class** when the class is instantiated. A class defined with a dependency on, or even knowledge of, a given trait can take advantage of that trait's functionality.

**Catch 22**
Traits added to a class' instantiation extend the class and not the other way round

```scala 
package com.oreilly

class User(val name: String) {
    def suffix = "";
    override def toString = s"$name$suffix"
}

trait Attorney { self: User => override def suffix = ", esq." };
trait Wizard { self: User => override def suffix = ", Wizard" };
trait Reverser { override def toString = super.toString.reverse };

val l = new User("Luna L") with Wizard with Reverser
```

**Hierarchy** 

It goes Reverser -> Wizard -> new User("Luna L"); As opposed to `new User("Luna L") -> Reverser -> Wizard`.

