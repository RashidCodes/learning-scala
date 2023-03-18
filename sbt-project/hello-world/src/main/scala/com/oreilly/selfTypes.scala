package com.oreilly

class ClassA { def hi = "hi" };

/* Self types 
 * -----------
 * A self type is a trait annotation that asserts that the trait MUST be 
 * mixed in with a specific type, or its subtype, when it is added to class.
 */
trait TraitB { self: ClassA => 
    override def toString = "B: " + hi
};

class ClassC extends ClassA with TraitB;


/* A better example  */
class TestSuite(var suiteName: String) { def start() = {} };

/* The trait needs to invoke TestSuite.start() but cannot extend 
 * TestSuite because it would require hardcoding the input parameter.
 * By using a self type, the trait can expect to be a subtype of TestSuite
 * without explicitly being declared as one.
 */
trait RandomSeeded { self: TestSuite =>
    def randomStart() = {
        util.Random.setSeed(System.currentTimeMillis);
        self.start()
    }
}

class IdSpec extends TestSuite("ID Tests") with RandomSeeded {
    def testId() = { println(util.Random.nextInt != 1) };
    override def start() =  testId();

    println(s"Starting ${suiteName}...");
    randomStart();
}