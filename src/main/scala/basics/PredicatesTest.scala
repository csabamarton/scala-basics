package basics

case class Email(subject: String,
                 text: String,
                 sender: String,
                 recipient: String
                )


object PredicatesTest extends App {
  type EmailFilter = Email => Boolean
  type SizeChecker = Int => Boolean

  def newMailsForUser(emails: Seq[Email], f: EmailFilter) = emails.filter(f)

  def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)

  val sentByOneOf: Set[String] => EmailFilter = senders => email => senders.contains(email.sender)
  val notSentByAnyOf = sentByOneOf andThen complement _

  val sendByOneOfFilter: EmailFilter = sentByOneOf(Set("csmarton@gmail.com"))

  val sizeConstraint: SizeChecker => EmailFilter = f => email => f(email.text.size)


  val minimumSize: Int => EmailFilter = minLimit => sizeConstraint(_ >= minLimit)
  val maximumSize: Int => EmailFilter = maxLimit => sizeConstraint(_ <= maxLimit)

  var mails = Email(
    "Test email 1",
    "This is a test email for email no.1",
    "csmarton@gmail.com",
    "adri@gmail.com") :: Nil

  val filteredEmails = newMailsForUser(mails, sendByOneOfFilter)

  //println(filteredEmails)


  def f(s: String) = "f(" + s + ")"

  def g(s: String) = "g(" + s + ")"

  val fComposedWithG = f _ compose g _

  val fAndThenG = f _ andThen g _

  //println(fComposedWithG("alma"))
  //println(fAndThenG("alma"))

  def any[A](predicates: (A => Boolean)*): A => Boolean = a => predicates.exists(pred => pred(a))

  def none[A](predicates: (A => Boolean)*): A => Boolean = complement(any(predicates: _*))

  //def every[A](predicates: (A => Boolean)*): A => Boolean = none(predicates.view.map(complement(_)): _*)
  //def every[A](predicates: (A => Boolean)*) = none(predicates.view.map(complement(_)): _*)
  def every[A](predicates: (A => Boolean)*): A => Boolean = a => predicates.forall(p => p(a))

  val filter: EmailFilter = every(
    sentByOneOf(Set("csmarton@gmail.com")),
    minimumSize(10),
    maximumSize(10000)
  )

  val addMissingSubject = (email: Email) =>
    if (email.subject.isEmpty) email.copy(subject = "No subject")
    else email

  val addImportantTextToFooter = (email: Email) =>
    email.copy(text = email.text + "\nRemember! The spice must flow!")

  val pipeline = Function.chain(Seq(
    addMissingSubject,
    addImportantTextToFooter)
  )

  mails.view.map(email => pipeline(email))
  println(newMailsForUser(mails, filter))

}


