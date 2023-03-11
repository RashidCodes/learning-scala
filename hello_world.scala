println("Hello from scala")

var testString: String = "Okay"

testString match {
  case "Ok" => {
    println("The testString is not empty");
    testString
  }
  case other => {
    println("The testString is empty")
    "n/a"
  }
}

for (x <- 1 to 100; final_x = if (x%5 == 0) s"${x}\n" else s"${x}, ") print(final_x)

