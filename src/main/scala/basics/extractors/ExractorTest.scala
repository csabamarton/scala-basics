package basics.extractors

object ExractorTest extends App {

  case class Address(city: String, state: String)
  case class Student(name: String, addresses: List[Address])

  object City {
    def unapply(student: Student): Option[Seq[String]] = {
      val states = for(address <- student.addresses) yield address.state
      if(states.isEmpty)
        None
      else
        Some(states)
    }
  }

  class StringSeqContains(value: String) {
    def unapply(in: Seq[String]): Boolean = {
      in contains value
    }
  }

  val student1 = Student("Csaba Marton", List(Address("Boulder", "Colorado"), Address("Palo Alto", "Califorgia")))
  val student2 = Student("Adrienne Nemeth", List(Address("Denver" ,"Colorado"), Address("Dallas", "Texas")))
  val students = List(student1, student2)

  val texas = new StringSeqContains("Texas")

  val studentsFromTexas = students collect {
    case student @ City(texas()) => student.name
  }

  println(studentsFromTexas)

}
