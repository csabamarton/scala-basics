object CollectionsPractise {
  val numbers = List(5, 4, 8, 6, 2)

  numbers.fold(2) { (a, i) =>
    a + i
  }


  class Person(val name: String, val age: Int, val sex: Symbol)

  object Person {
    def apply(name: String, age: Int, sex: Symbol): Person =
      new Person(name, age, sex)
  }

  val persons =
      Person("Csaba Marton", 31, 'male) ::
      Person("Adri Nemeth", 26, 'female) ::
      Person("Alfons Brock", 21, 'male) :: Nil

  val compressedPersons = persons.foldLeft(List[String]()) { (z, person) =>
    val title = person.sex match {
      case 'male => "Mr."
      case 'female => "Ms."
    }

    z :+ s"$title ${person.name}, ${person.age}"
  }


}