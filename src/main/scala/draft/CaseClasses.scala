package draft

import scala.io.Source

object CaseClasses extends App {
  abstract class Notification

  case class Email(from: String, title: String, body: String) extends  Notification
  case class SMS(number: Int, message: String) extends Notification

  val importantEmail = "important@google.com"
  val importantSMS = "5551111"

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(from, title, _) => "New email from " + from + " about: " + title
      case SMS(number, message) => "New SMS from " + number + ": " + message
    }
  }

  def showSpecialNotification(notification: Notification): String = {
    notification match {
      case Email(from, _, _) if from == importantEmail => "Important email from google"
      case SMS(number, _) if number == importantEmail => "Important SMS!"
      case other => showNotification(notification)
    }
  }

  val email = Email("zsh@gmail.com", "Hy", "How's going?")
  val email2 = email.copy(from = importantEmail)

  println("Check Emails")
  println(showSpecialNotification(email))
  println(showSpecialNotification(email2))
}
