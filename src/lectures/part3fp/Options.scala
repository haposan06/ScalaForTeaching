package lectures.part3fp

import scala.util.Random

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption:Option[Int] = None

//  println(myFirstOption)
//  println(noOption)

  def unsafeMethod:String = ""

//  println(Some(unsafeMethod)) //WRONG
//  println(Option(unsafeMethod)) // RIGHT if using Option. Will return Some of None depends on result

//  val option = for {
//    v <- myFirstOption
//  } yield println(v)


  val config:Map[String, String] = Map(
    "host" -> "127.0.0.1",
    "port" -> "7076"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host:String, port:String):Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else
        None
    }
  }

//  val connectStatus:String = (Connection(config("host"), config("port")) orElse Some("Its not connected")).toString
//
  val host = config.get("host")
  val port = config.get("port")
//  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
//  val connectionStatus = connection.map(c=> c.connect)
//  val finalStatus = connectionStatus.foreach(println(_))

  val finalStatus2 = for {
    h <- host
    p <- port
    c <- Connection(h,p)
  } yield c.connect
  println(finalStatus2)
  finalStatus2.foreach(println)
}
