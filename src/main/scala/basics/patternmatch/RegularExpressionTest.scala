package basics.patternmatch

object RegularExpressionTest extends App {
  val pattern = """\((\d\d\d)\) (\d\d\d) (\d\d\d)""".r

  val phoneBook = """Csaba (123) 456 789
    Adri (234) 567 890
    Chris (345) 678 901
    """

  for (m <- pattern.findAllMatchIn(phoneBook)) {
    val areaCode = m.group(1)

    println(areaCode)
  }
}
