package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {
  val aSuccess = Success("Its a success result")
  val aFailer = Failure(new RuntimeException("Actually a success reult"))

  def unsafeMethod = 2 / 0
  val potentialFailure = Try(unsafeMethod)
//  println(potentialFailure)

  def betterUnsafeMethod : Try[String] = Failure(new RuntimeException)
  def betterBackupMethod : Try[String] = Success("a valida result")
  val result = betterUnsafeMethod orElse betterBackupMethod

  val result2 = betterUnsafeMethod.flatMap(x=>Success(x + "aa"))
  val mapResult = betterUnsafeMethod.map(x=> x + "aa")
  val filterResult = betterUnsafeMethod.filter(_.equals("aa"))

  val hostName = "localhost"
  val port = "8084"

  def renderHtml(page:String) = println(page)

  class Connection {
    def get(url:String) : String = {
      val rand = new Random(System.nanoTime())

      if (rand.nextBoolean()) return "<html><text>Test</text></html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def safeGet(url:String): Try[String] = Try(get(url))
  }

  object HttpService {
    val rand = new Random(System.nanoTime())
    def getConnection(host:String, port:String) : Connection = {
      if(rand.nextBoolean()) return new Connection
      else throw new RuntimeException("Address / port already in used")
    }

    def safeGetConnection(host:String, port:String): Try[Connection] = Try(getConnection(host, port))
  }

//  val getConnection:Try[Connection] = {
//    val conn : Connection = new Connection
//
//    conn
//  }

  val possibleConnection = HttpService.safeGetConnection(hostName, port)
  val possibleResult = possibleConnection.flatMap(c => c.safeGet("/boom"))
  possibleResult.foreach(renderHtml(_))
  println("Processing...")
  val finalRes = for {
    c <- HttpService.safeGetConnection(hostName, port)
    s <- c.safeGet(hostName + port)
  } yield renderHtml(s)

  val mapList = List(1,2,3)
  val mapListResult = mapList.map(x=>Option(x * 2))
  println(mapListResult)

  val flatMapList = mapList.flatMap(x=>Option(x + 1))
  println(flatMapList)



}

