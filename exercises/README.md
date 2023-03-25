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

