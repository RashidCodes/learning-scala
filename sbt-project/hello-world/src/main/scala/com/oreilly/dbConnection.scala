package com.oreilly 

object DBConnection {
    /* store database connection data in 
     * private constants
    */
    private val db_url = "jdbc://localhost"
    private val db_user = "franken"
    private val db_pass = "berry"

    def apply() = new DBConnection
}

class DBConnection {

    /* class of the same name is able to read
     * the private constants. The constants are
     * safe from being read by any other part of the system
     */
    private val props = Map(
        "url" -> DBConnection.db_url,
        "user" -> DBConnection.db_user,
        "pass" -> DBConnection.db_pass
    )

    println(s"Created new connection for " + props("url"))
}