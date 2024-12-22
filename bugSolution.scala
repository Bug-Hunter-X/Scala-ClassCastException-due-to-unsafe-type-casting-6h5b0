```scala
class MyClass[T](val value: T) {
  def myMethod[U >: T](other: MyClass[U])(implicit ev: T => U): U = {
    (value, other.value) match {
      case (a: Int, b: Int) => a + b
      case (a: String, b: String) => a + b
      case _ => throw new IllegalArgumentException("Unsupported type")
    }
  }
}

object Main extends App{
  val intInstance1 = new MyClass[Int](10)
  val intInstance2 = new MyClass[Int](20)
  val stringInstance1 = new MyClass[String]("Hello")
  val stringInstance2 = new MyClass[String]("World")

  println(intInstance1.myMethod(intInstance2))
  println(stringInstance1.myMethod(stringInstance2))

  // This will not throw ClassCastException
  val mixedType = new MyClass[Any](10)
  val mixedType2 = new MyClass[Any]("string")
  println(mixedType.myMethod(mixedType2)) 
}
```