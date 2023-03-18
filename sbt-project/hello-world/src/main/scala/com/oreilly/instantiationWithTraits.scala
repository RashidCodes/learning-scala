package com.oreilly

class User(val name: String) {
    def suffix = "";
    override def toString = s"$name$suffix"
}

trait Attorney { self: User => override def suffix = ", esq." };
trait Wizard { self: User => override def suffix = ", Wizard" };
trait Reverser { override def toString = super.toString.reverse };
