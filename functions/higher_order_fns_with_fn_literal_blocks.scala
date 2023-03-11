/* Invoking higher-order function with function literal blocks */

def safeStringOp(s: String, f: String => String): String = {
  if (s != null) f(s)
  else s
}


val uuid = java.util.UUID.randomUUID.toString

val timedUIID = safeStringOp(uuid, { s => 
  val now = System.currentTimeMillis;
  val timed = s.take(24) + now;
  timed.toUpperCase 
})


/* using parameter groups to improve the syntax */

def betterSafeStringOp(s: String)(f: String => String) = {
  if (s != null) f(s) 
  else s
}

val timedUUIDNew = betterSafeStringOp(uuid){ s =>
  val now = System.currentTimeMillis;
  val timed = s.take(24) + now;
  timed.toUpperCase
}


def timer[A](f: => A): A = {
  def now = System.currentTimeMillis;
  val start = now; val a = f; val end = now;
  println(s"Executed in ${end - start} ms");
  a
}

/* this syntax is pretty scary */
val veryRandomAmount = timer {
  util.Random.setSeed(System.currentTimeMillis);
  for (i <- 1  to 100000) util.Random.nextDouble;
  util.Random.nextDouble;
}
