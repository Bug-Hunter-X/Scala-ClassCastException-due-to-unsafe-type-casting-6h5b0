```scala
class MyClass[T](val value: T) {
  def myMethod(other: MyClass[T]): T = {
    value match {
      case _: Int => value.asInstanceOf[Int] + other.value.asInstanceOf[Int] 
      case _: String => value.toString + other.value.toString
      case _ => throw new IllegalArgumentException("Unsupported type")
    }
  }
}

object Main extends App{
  val intInstance1 = new MyClass[Int](10)
  val intInstance2 = new MyClass[Int](20)
  val stringInstance1 = new MyClass[String]("Hello")
  val stringInstance2 = new MyClass[String]("World")

  println(intInstance1.myMethod(intInstance2)) // Output: 30
  println(stringInstance1.myMethod(stringInstance2)) // Output: HelloWorld

  //This will cause ClassCastException at runtime
  val mixedType = new MyClass[Any](10)
  val mixedType2 = new MyClass[Any]("string")
  println(mixedType.myMethod(mixedType2)) 
}
```