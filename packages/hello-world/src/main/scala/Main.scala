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

  // can't call from outsie the oreilly package
  util.Try(new com.oreilly.Config)



  



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

