package com.oreilly

// class Car { override def toString = "Car()" };
// class Volvo extends Car { override def toString = "Volvo()" };

/* Type variance 
 * You can mark a type parameter as being covariant by adding
 * a plus sign (+) in front of the type parameter
 */
// case class Item[+A](a: A) { def get: A = a };


/* ContraVariance */
class Car; class Volvo extends Car; class VolvoWagon extends Volvo;

class Item[+A](a: A) { def get: A = a };
class Check[-A] { def check(a: A) = {} };

def item(v: Item[Volvo]) = { val c: Car = v.get };
def check(v: Check[Volvo]) = { v.check(new VolvoWagon()) }


implicit class SumTuples(i: Tuple) {
    def sum(someTuple: Tuple): Double = {
        var acc = 0.0;

        someTuple.productIterator.foreach { b => {
            b match {
                case i: Double => { acc = acc + i }
                case i: Int => { acc = acc + i }                
                case _ => { -1 }
            }
        }}

        acc 
    }
}


