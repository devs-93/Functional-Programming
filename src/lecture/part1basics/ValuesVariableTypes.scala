package lecture.part1basics

object ValuesVariableTypes extends App {
  //Values are Imputable
  val x: Int = 42
  println(x)

  //Compiles can Infer Type
  val y = "Scala is Fun"
  println(y)

  //Datatype in scala
  val anInt: Int = 65
  val aShort: Short = 4613
  val aLong: Long = 4613234567889L
  val aFloat: Float = 2.4f
  val aDouble: Double = 3.14
  val aString: String = "Scala is Fun!!"
  val aChar: Char = 'S'
  val aBoolean: Boolean = false

  //variables
  //its mutable and you can changes its value
  var aVariable: Int = 25 //side effect
  aVariable = 100


}
