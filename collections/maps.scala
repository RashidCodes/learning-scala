/* Maps in Scala 
 *
 * Implemented as Objects in JS or dictionaries in Python
 */

val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)

// check if a map contains a key 
colorMap.contains("white");

// printout only map keys 
for (pairs <- colorMap; color = pairs._1) println(color);
