package com.oreilly 

object ImplicitClasses {
    implicit class Hello(s: String) { def hello = s"Hello, $s"};
    def test = println("from scala".hello)
};