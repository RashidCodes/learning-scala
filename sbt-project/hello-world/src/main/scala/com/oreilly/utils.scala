package com.oreilly 
import com.oreilly.FlexibleBase 

object utils {
    def increment[B <: FlexibleBase](b: FlexibleBase) = {
        b.i += 1; b 
    }
}