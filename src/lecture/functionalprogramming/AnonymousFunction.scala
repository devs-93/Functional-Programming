package lecture.functionalprogramming

object AnonymousFunction extends App {

  //Object oriented way of calling and doing the things
  val doubler = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * v1
  }

  val additionLambda = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + v1
  }
  //Syntactic Sugar for this additionLambda====> This is called anonymous function(LAMBDA FUNCTION)
  val additionLambda1 = (v1: Int) => v1 + v1
  //OR YOU CAN WRITE MORE PRECIS CODE LIKE
  val additionLambda2: Int => Int = (v1: Int) => v1 + v1
  //OR YOU CAN WRITE MORE PRECIS CODE LIKE
  val additionLambda3: Int => Int = v1 => v1 + v1


  /** *********************
   * Multiple param in lambda
   * ********************* */

  val superAdditionLambda: (Int, Int, Int, Int) => Int = (v1: Int, v2: Int, v3: Int, v4: Int) => v1 + v1 + v2 + v3 + v4


  /** *********************
   * **** No param in lambda
   * ********************* */

  val justDoSomething: () => String = () => "No Param to Process !!"
  //Be care full with lambda calling
  println(justDoSomething) //this is function itself
  println(justDoSomething()) //this is actual function call with no param


  /** ****************************************
   * *****Writing lambda with Curly brackets**
   * **************************************** */
  val justStringToInt = {
    (str: String) => str.toInt
  }


  /** ****************************************
   * ********** MOAR SYNTACTIC SUGAR IN SCALA**
   * ***************************************** */

  val niceIncrementer: Int => Int = (x: Int) => x + 1
  //Syntactic Sugar is
  //val niceIncrementer: Int => Int = _+1

  val niceAdder: (Int, Int, Int) => Int = (x: Int, y: Int, z: Int) => x + y + z
  //Syntactic Sugar is
  //val niceAdder: (Int, Int, Int) => Int = _+_+_

  /** *****************************************************
   * ********** Curried Function to MOAR SYNTACTIC SUGAR***
   * ******************************************************/
  /*
  //Function1[Int,Function1[Int,Int]]
  val superAdder: (Int) => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
  * */
  val superAdder = (x: Int) => (y: Int) => x + y
  println(superAdder(10)(11))


  println(superAdditionLambda(10, 10, 10, 9))
  println(additionLambda(10))
  println(additionLambda1(10))
  println(justStringToInt("100"))

}
