package basics.classandprops

object ClassTest extends App {
  class Person(var firstName: String, var lastName: String) {
    println("Constructor Begins")

    private val HOME = System.getProperty("user.home")
    var age = 0

    override def toString: String = s"$firstName $lastName is $age years old"
    def getFullName(): String = s"$firstName $lastName"
    def printHome() = println(s"Home is $HOME")

    printHome()
    println(getFullName())
    println(this)

    println("Constructor Ends")
  }

  var john = new Person("John", "Doe")




}
