package com.oreilly {

    /* Config can be accessed by any class within the 
     * oreilly package only 
     */
    private[oreilly] class Config {
        var url = "http://localhost"
    }

    /* val password can only be accessed from the 
     * Authentication class
     */
    class Authentication {
        private[this] val password = "json";
        def validate = password.size > 0;
    }

    class Test {
        println(s"url = ${new Config().url}")
    }
}