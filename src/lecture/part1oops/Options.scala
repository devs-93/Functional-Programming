package lecture.part1oops

import scala.util.Random

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  //work with Unsafe APIs
  def unsafeMethod(): String = null

  val result = Some(unsafeMethod())
  println(unsafeMethod())
  println(result)

  val resultNew = Option(unsafeMethod())
  println(resultNew)

  //chained method
  def backupMethod(): String = "A valid Result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)

  //Design unsafe APIS
  def betterUnsafeMethod(): Option[String] = {
    None
  }

  def betterBackupMethod(): Option[String] = {
    Some("A valid Result")
  }

  val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterChainedResult)

  //function on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // unsafe - do not use this

  // map , flatmap , filter
  println(myFirstOption.map(x => x * 2))
  println(myFirstOption.filter(x => (x % 3 == 0)))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for comprehension
  val config: Map[String, String] = Map(
    "host" -> "127.0.0.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) {
        Some(new Connection)
      }
      else {
        None
      }
    }
  }

  // try to establish a connection if you able to do so print the connect method
  val host = config.get("host")
  val port = config.get("port")


  /*
  if (h!=null)
     if(p!=null)
         return Connection.apply(h,p)
  return null
  */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))


  /*
  if(c!=null)
     return c.connect()
  return null
  */
  val connectionStatus = connection.map(c => c.connect)


  /*
  if connectionStatus==null
     print(none)
  else
     print(Some(connectionStatus.get))
  */
  println(connectionStatus)


  /*
  if connectionStatus != null
     println(connectionStatus)
  */
  connectionStatus.foreach(println)


  /*
  shorter version to do the same connection code (chained call)
  */
  println("chained call ")
  println()
  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(p => Connection(h, p))
      .map(c => c.connect)).
    foreach(println)


  //for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connectObj <- Connection.apply(host, port)
  } yield connectObj.connect

  forConnectionStatus.foreach(println)


}
