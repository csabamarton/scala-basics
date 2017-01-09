import javax.management.Notification

object CaseClasses {
  abstract class Notification
  case class Email(source: String, title: String, body: String) extends  Notification

  val email = Email("zsh@gmail.com", "Hy", "How's going?")

  val modifiedEmail = email.copy(title = "Changed Title")

}