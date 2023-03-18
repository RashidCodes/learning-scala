package com.oreilly

/* if final classes are too restrictive for your needs, consider sealed classes instead.
* Sealed classes restrict the subclasses of a class to being located in the same file as the parent.
*/

sealed class SealedClass(val name: String, val age: Int) {
  def showName: String = s"Hello I'm $name and I've lived on earth for ${age} years"
}

class SubclassedSealed(val height: String = "6'4") extends SealedClass("rashid", 26) {
  def showHeight: String = s"I'm ${height} tall";
}