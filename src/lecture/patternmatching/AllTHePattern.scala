package lecture.patternmatching

import lecture.oops.Generics.MyList
import exercices.MyList

object AllTHePattern extends App {

//    // 1 - constant
//    val x: Any = "Scala"
//    val constants = x match {
//      case 1 => "a number"
//      case "Scala" => "The Scala"
//      case true => "The Truth"
//      case AllTHePattern => "Singleton Object"
//    }
//
//    // 2 - match anything
//    val matchAnything = x match {
//      case _ =>
//    }
//
//    // 3- variable
//    val matchAVariable = x match {
//      case something => s"I have found $something"
//    }
//
//    // 4- tuples
//    val aTuple = (1, 2)
//    val matchATuple = aTuple match {
//      case (1, 1) =>
//      case (something, 2) => s"I have found $something"
//    }
//    val nestedTuple = (1, (2, 3))
//    val nestedTupleNew = nestedTuple match {
//      case (_, (2, v)) =>
//    }
//
//    // PMS can be nested
//  //  val aList:MyList[Int]=Cons
//
//    // 5 - list pattern
//    val sStandardList = List(1, 2, 3, 42)
//    val sStandMatch = sStandMatch match {
//      case List(1, _, _, _) => //extractor - advance
//      case List(1, _*) => // List of arbitrary length
//      case 1 :: List(_) => //infix pattern
//      case List(1, 2, 3) :+ 42 => //infix pattern
//    }
//
//    //6 - Types specifier
//    val unknown: Any = 2
//    val unknownMatch = unknown match {
//      case list: List[Int] => // explicit type specifiers
//      case _ =>
//    }
//
//    //7 - multipart
//    val multipattern= String match {
//      case "" | "New String" => // compound pattern
//    }
//
//  //8 - if Guards
//
//
//  // All Done

  /*
  Question
  */
  val number = List(1, 2, 3, 4, 5, 6, 7, 8, 8)
  val numberMatch = number match {
    case listOfInteger: List[Int] => "This is List of Integer"
    case listOfString: List[String] => "This is List of String"
  }

  println(numberMatch)


}
