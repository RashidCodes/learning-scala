/* Collection Builders
 *
 * A builder is a simplified form of a Buffer, restricted to generating its assigned collection type and supporting only 
 * append operations
 */


/* To create a builder for a specific collection type, invoke the type's newBuilder method and include the type of the 
 * collection's element
 */

val b = Set.newBuilder[Char]
b += 'h';
b ++= List('e', 'l', 'l', 'o')
var helloSet = b.result

