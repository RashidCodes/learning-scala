package com.oreilly 

object IntUtils {
    /* an implicit class must be defined within another object,
     * class or trait.
     * The must take a single nonimplicit class argument.
     */
    implicit class Fishies(val x: Int) {
        def fishes = "Fish" * x;
    }
}