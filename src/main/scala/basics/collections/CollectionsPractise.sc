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

  val compressedPersonsFromLeft = persons.foldLeft(List[String]()) { (z, person) =>
    val title = person.sex match {
      case 'male => "Mr."
      case 'female => "Ms."
    }

    z :+ s"$title ${person.name}, ${person.age}"
  }

  val compressedPersonsFromRight = persons.foldRight(List[String]()) { (p, z) =>
    val title = p.sex match {
      case 'male => "Mr."
      case 'female => "Ms."
    }

    z :+ s"$title ${p.name}, ${p.age}"

  }


  val (names, ageSum) = persons.foldLeft("", 0) { case ((sexList, ageList), person) =>
    (sexList + " " + person.name, ageList + person.age)


  }


  val nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

  val newNums = nums.grouped(2).toList.map {
    case List(x, y) => x * y
    case x :: Nil => x
  }


  /* def recur(xs: List[Int]): List[Int] = {
     xs match {
       case (x :: y :: rest) => (x * y) :: recur(rest)
       case x :: Nil => List(x)
     }
   }

   recur(nums)
 */

  val list = List(1, 1, 2, 3, 5, 8, 9)

  def lastRecursive[A](xs: List[A]): A = xs match {
    case x :: Nil => x
    case (_ :: rest) => lastRecursive(rest)
    case _ => throw new NoSuchElementException
  }

  val last = lastRecursive(list)

  def lastBeforeOneRecursive[A](xs: List[A]): A = xs match {
    case x :: _ :: Nil => x
    case _ :: rest => lastBeforeOneRecursive(rest)
    case _ => throw new NoSuchElementException

  }

  val lastBeforeOne = lastBeforeOneRecursive(list)

  def nth(n: Int, xs: List[Int]): Int = (n, xs) match {
    case (0, h :: _) => h
    case (n, _ :: tail) => nth(n-1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  nth(2, list)

  def length(xs: List[Int]): Int = xs match {
    case _ :: Nil => 1
    case _ :: rest => 1 + length(rest)
  }

  length(list)

  list.foldLeft(0) { (c, _) => c + 1}
}