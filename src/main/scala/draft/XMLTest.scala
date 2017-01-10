package draft

object XMLTest extends App {
  val df = java.text.DateFormat.getDateInstance()
  val dateString = df.format(new java.util.Date())

  def theDate(name: String) =
    <dateMsg addressedTo={name}>
      Hello, {name}! Today is {dateString}
    </dateMsg>;
  println(theDate("John Doe").toString())
}
