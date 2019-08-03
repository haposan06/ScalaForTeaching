package lectures.part3fp

object TuplesAndMaps extends App {
  val aTuple = new Tuple3("hi", 2, 3.3)
  val twoTuple = (1,2)
  twoTuple.swap
  val arrowTuple = (1->"33")
  println(aTuple)
//  println(aTuple.swap)
  def add(network: Map[String, Set[String]], person:String):Map[String,Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], personA:String, personB:String):Map[String,Set[String]] = {
    val networkA = network(personA)
    val networkB = network(personB)

    network + (personA -> (networkA + personB)) + (personB-> (networkB + personA))
  }

  def unfriend(network: Map[String, Set[String]], personA:String, personB:String):Map[String,Set[String]] = {
    val networkA = network(personA)
    val networkB = network(personB)

    network + (personA -> (networkA - personB)) + (personB-> (networkB - personA))
  }

  def remove(network: Map[String, Set[String]], personA:String):Map[String,Set[String]] = {
    val newNetwork = network - personA
    newNetwork.map(pair => {
      pair._1 -> pair._2.filter(name=> !name.equals(personA  ))
    })
//    def removePersonFromSet(networkz: Map[String, Set[String]], name:String): Map[String, Set[String]] = {
//      if (network.head._1.equals(personA)) return networkz
//      else
//
//      val set = networkz(network.head)
//      set - name
//    }
//    removePersonFromSet(network.head._2, personA)


//    remove(network.tail, personA)
  }
  val network:Map[String,Set[String]] = Map()
  var newNetwork = add(network, "Johannes")
  newNetwork = add(newNetwork, "Gaby")
  newNetwork = add(newNetwork, "Laura")
  newNetwork = add(newNetwork, "Malo")
  newNetwork = friend(newNetwork, "Johannes", "Gaby")
  newNetwork = friend(newNetwork, "Laura", "Gaby")
  newNetwork = friend(newNetwork, "Malo", "Gaby")
  newNetwork = remove(newNetwork , "Gaby")
  println(newNetwork)

}

