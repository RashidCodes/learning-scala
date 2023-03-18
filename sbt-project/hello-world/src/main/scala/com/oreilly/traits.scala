package com.oreilly

/* Linearization 
 * The process of taking horizontal list of a class and traits being extended
 * and reforming them into a vertical chain of one class extending
 * another is known as Linearization
 */
trait Base { override def toString = "Base" };

// class extending a trait
class A extends Base { override def toString = "A->" + super.toString };

// trait extending a trait 
trait B extends Base { override def toString = "B->" + super.toString };

//  trait extending a trait 
trait C extends Base { override def toString = "C->" + super.toString };

// multiple inheritance
class D extends A with B with C {
    override def toString = "D->" + super.toString
}