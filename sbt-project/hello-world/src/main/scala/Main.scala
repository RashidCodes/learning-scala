import users.{ User => UserUpgraded }
import collection.mutable.Buffer
import com.oreilly._

@main def main: Unit =
// val isValid = new ValidUser().isValid
  // println(isValid)

  val u = new UserUpgraded().sayHello;
  // var isValid = u.validate("4567");
  // println(isValid);
  // u.update("4567");
  // isValid = u.validate("4567");
  // println(isValid);

  val valid = new com.oreilly.Authentication().validate
  // println(valid);

  new com.oreilly.Test;

  /* can't call from outsie the oreilly package
   * new com.oreilly.Config
   */

  val sealedClass: SealedClass = SealedClass(name = "Rashid", age = 26);
  val subclassed: SubclassedSealed = SubclassedSealed();

  // println(subclassed.showHeight);
  // println(sealedClass.showName);

  val tripler = Multiplier(3); // invokes the apply method
  val result = tripler.product(13);

  // println(result)
  val conn = DBConnection();

  // println(new D())

  val red = new Paint(128 << 16).hex;
  val blue = new Overlay(192).hex;

  println(blue);

  val spec: IdSpec = new IdSpec();

  val h = new User("Harry P") with Wizard;

  println(h);

  /* Importing instance members */
  // {
  //   val latteReceipt = Receipt(123, 4.12, "fred", "Medium Latte");
  //   import latteReceipt._
  //   println(s"Sold a $title for $amount to $who")
  // }

  println(ImplicitClasses.test)

  {
    import com.oreilly.IntUtils._
    println(3.fishes)
  }

  val flexible = FlexibleBase()
  val incremented = utils.increment(flexible);
  println(incremented.i)

  /* type parameters can morph into compatible types, even when bound in a
   * new instance 
   */
  val l: List[FlexibleBase] = List[FlexibleSub]()

  val g: Car = new Volvo();

  val c: Item[Car] = new Item[Volvo](new Volvo)



  // protected: vars/vals are accessible to the main class as well
  // as subclasses
  // class User { protected val passwd = util.Random.nextString(10) };
  // class ValidUser extends User { def isValid = !passwd.isEmpty; };

  // Private: Only accessible in the super class
  // class User(private var password: String) {
  //   def update(p: String) = {
  //     println("Modifying the password");
  //     password = p;
  //   }

  //   def validate(p: String) = p == password;
  // }


  // try subclassing a final class
  final class FinalClass(var a: Int) {
    def showA: Unit = {
      println(s"($a)")
    }
  }

  // class B extends FinalClass(12);



  case class Receipt(id: Int, amount: Double, who: String, title: String);


