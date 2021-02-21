package lecture.part1oops


import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  // create success and failure explicit
  val success = Success(3)
  val failure = Failure(new RuntimeException("SUPER Failure"))

  println(success)
  println(failure)

  def unsafeMethod(): String = throw new RuntimeException("No STRING FOR YOU !!")

  // Try object creation
  def potentialFailure = Try(unsafeMethod())

  println(potentialFailure)


  //another way of writing try block
  def anotherPotentialFailure = Try {

  }

  // some method provided by Try
  println(potentialFailure.isFailure)
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod: String = "A valid Result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod))
  println(fallbackTry)

  //if you design API
  def betterUnsafeMethod(): Try[String] = {
    Failure(new RuntimeException("Error"))
  }

  def betterBackupMethod(): Try[String] = {
    Success("Done my Task")
  }

  val result = betterUnsafeMethod().orElse(betterBackupMethod())
  println(result)


  //Try type has map,flatmap,filter
  println(success.map(x => x * 2))
  println(success.flatMap(x => Success(x * 10)))
  println(success.filter(x => (x > 10)))

  /*
  Exercise
  */

  val hostname = "localhost"
  val port = "8080"


  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) {
        "<html>....</html>"
      }
      else {
        throw new RuntimeException("oops connection failed")
      }
    }

    def getSafe(url: String): Try[String] = {
      Try(get(url))
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) {
        new Connection()
      }
      else {
        throw new RuntimeException("Connection Used By other service")
      }
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = {
      Try(getConnection(host, port))
    }
  }


  // if you get html page from a connection print it to console
  val possibleConnection = HttpService.getSafeConnection(hostname, port)
  val possibleHTML = possibleConnection.flatMap(c => c.getSafe("/home"))
  possibleHTML.foreach(page => println(page))


  // shorthand version
  HttpService.getSafeConnection(hostname, port)
    .flatMap(c => c.getSafe("/home"))
    .foreach(x => println(x))


  //for - comprehension version
  println("for - comprehension version")
  for {
    connection <- HttpService.getSafeConnection(hostname, port)
    htmlPage <- connection.getSafe("/home")
  } yield {
   println(htmlPage)
  }

}


