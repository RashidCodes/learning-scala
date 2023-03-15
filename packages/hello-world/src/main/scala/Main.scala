import users.User 
import collection.mutable.Buffer 
import com.oreilly

@main def main: Unit = 
  // val isValid = new ValidUser().isValid
  // println(isValid)

  // val u = new User("1234");
  // var isValid = u.validate("4567");
  // println(isValid)
  // u.update("4567");
  // isValid = u.validate("4567");
  // println(isValid);

  val valid = new com.oreilly.Authentication().validate
  println(valid);

  new com.oreilly.Test;

  /* can't call from outsie the oreilly package
   * new com.oreilly.Config
   */

  val sealedClass: SealedClass = SealedClass(name = "Rashid", age = 26);
  val subclassed: SubclassedSealed = SubclassedSealed();

  println(subclassed.showHeight);
  println(sealedClass.showName);




class Legendary {
  var name: String = "Rashid";
  def presentName: String = "Presented!"
}

// protected: vars/vals are accessible to the main class as well 
// as subclasses
// class User { protected val passwd = util.Random.nextString(10) };
// class ValidUser extends User { def isValid = !passwd.isEmpty; };

// Private: Only accessible in the super class 
class User(private var password: String) {
  def update(p: String) = {
    println("Modifying the password");
    password = p;
  }

  def validate(p: String) = p == password;
}


// try subclassing a final class 
final class FinalClass (var a: Int){
  def showA: Unit = { println(s"($a)") }
}

// class B extends FinalClass(12);

/* if final classes are too restrictive for your needs, consider sealed classes instead.
 * Sealed classes restrict the subclasses of a class to being located in the same file as the parent.
 */

sealed class SealedClass (val name: String, val age: Int){
  def showName: String = s"Hello I'm $name and I've lived on earth for ${age} years"
}

class SubclassedSealed(val height: String = "6'4") extends SealedClass("rashid", 26) {
  def showHeight: String = s"I'm ${height} tall";
}


  
