package lecture.part1basics

object StringOps extends App {


  //Java and Scala has same set of method to string manipulation

  val str = "Hello I am learning Scala"
  println(str.charAt(3))
  println(str.substring(1, 4))
  println(str.split(" ").toList)
  println(str.startsWith("hello"))
  println(str.startsWith("Hello"))
  println(str.replace("Hello", "HELLO"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length())

  //Scala Specific method to string manipulation

  val aNumberString = "42"
  val aNumberStringToInt = aNumberString.toInt
  println(aNumberString)
  println(aNumberStringToInt)


  //prepending and postpending is scala specific
  println('a' +: " Shukla " :+ 'z')
  println(str.reverse)
  println(str.length())
  println(str.take(5))

  //s interpolation in string manipulation
  val name = "David"
  val age = 27
  val gender = "Male"
  val stringData1 = s"Hello my name is $name and my age is about to $age and I am $gender tell me something about you ?"
  println(stringData1)
  val stringData2 = s"Hello my name is ${name + " shukla"} and my age is about to ${age + 1} and I am ${gender + 1} tell me something about you ?"
  println(stringData2)

  //f interpolation in string manipulation
  val speed = 1.2f
  println(f"$name can eat $speed%1.5f burger per minute")

  //raw interpolation
  println(raw"This is the best \n song ever composed")
  val sData = "This is the best \n song ever composed"
  println(raw"$sData")


}
