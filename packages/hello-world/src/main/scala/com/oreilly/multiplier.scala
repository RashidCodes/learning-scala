package com.oreilly

class Multiplier(val x: Int) { def product(y: Int) = x * y }

/* companion object 
A companion object is an object that shares the same name as a class 
and is defiend together in the same fie as the class.
*/
object Multiplier { def apply(x: Int) = new Multiplier(x) };