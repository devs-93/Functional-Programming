package lecture.oops

import playground.PrinceCharming
//OR
import playground._


// aliasing for import method to avoid conflicts

import java.util.{Date => SqlDate}
import java.sql.{Date => SysDate}


object PackagingAndImports extends App {


  //package name are accessible by their simple name
  val writer = new Writer("Shiv", "Shankar", 1993)

  //import the package

  import playground.ScalaPlayground

  val scalaPlayground1 = ScalaPlayground
  // OR
  // using fully qualified name
  val scalaPlayground2 = playground.ScalaPlayground


  // package are in hierarchy
  // matching folder structure
  sayNoToLaziness()
  println(SPEED_OF_LIGHT)


  //import
  val prince = new PrinceCharming

  //1.use FQ name
  val sqlDate = new SqlDate()
  val systemDate = new SysDate(2018, 5, 4)
  println(systemDate)
  println(sqlDate)


  // default imports
  // java.lang - String,Object,Exception
  // scala -     Int ,Nothing,Function
  // scala.Predef - println, ???


}
