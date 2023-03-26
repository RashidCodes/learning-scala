# Question
How would you add a "sum" method on all tuples, which returns the sum of all numeric values in a tuple? For example *(a, "hi", 2.5, 1, true).sum* should return *3.5*

```scala 
implicit class SumTuples(i: Tuple) {
    def sum = {
        var acc = 0.0;

        i.productIterator.foreach { b => {
            b match {
                case c: Double => { acc = acc + c }
                case c: Int => { acc = acc + c }                
                case _ => { -1 }
            }
        }}; acc 
    }
}
```

# Question
How would you extend a function? What are some of the applications for a class or trait that extends `Function1[A,B]`? If you're writing such a class or trait, would you extend `Function1[A,B]` or choose to extend `A => B`

# Answer 
The benefit of extending `Function1[A,B]` as compared to just defining `apply` is just that you can pass this object where a `Function1` is expected. e.g.

```scala
class E extends (Int => String_) {
   def apply(name: Int) = s"This is the number: $name"
}

class D extends Function1[Int, String]{
   def apply(name: Int) = s"This is the number: $name"
}
```

# Question 
How would you write a function type for a function that has two parameter lists, each with a single integer, and returns a single integer? If you wrote it as a `FunctionX` class, what would the exact class and type paramter contain?

```scala 
def testFunc(a: Int)(b: Int): Int = a + b;

testFunc(2)(3)
```


