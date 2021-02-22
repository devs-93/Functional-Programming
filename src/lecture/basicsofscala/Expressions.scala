package lecture.basicsofscala

object Expressions extends App {


  //Expression
  val x = 1 + 3
  println(x)



  //mathematics expression
  // + - * & | ^ << >> >>>(right shift specific to scala)
  println(2 + 3 * 10)


  //relational expression
  // == != < > >= <=
  println(1 == x)


  //Boolean Expression
  // ! && ||
  println(!(1 == x))


  //also work for *= += -=(changing var is called side effect)
  var aVar = 2
  aVar += 3
  println(aVar)


  //Instruction(DO) vs Expression(VALUE)
  val aCondition = true
  val aConditionEvaluation = if (aCondition) 500 else 1 //(It return value that's why it is Expression not Instruction)
  println(aConditionEvaluation)
  println(if (aCondition) 500 else 1)


  //While loop in scala(but this would be discourage to use them)
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }


  //Everything in scala is expression

  // Unit == Void
  // side effect return type is Unit
  // println(),while,reassigning are side effect and don't return value
  val aWhileValue = while (i < 10) {
    println(i)
    i += 1
  }
  var aVaribale = 11
  val aWeirdValue = (aVaribale = 10)


  //CodeBlock
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 1) "Good to Go !!" else "Good Bye !!"
  }
  println(aCodeBlock)


}
