object HigherOrderMethods {

  val arr1 = Array.range(1, 5)
  val arr2 = Array.range(1, 9, 2)
  val arr3 = List.tabulate(6)(i => i + 3)

  arr1.map(_ * 3)

  arr2.filter(_ < 9)

  arr1.flatMap(i => arr2.take(i))

  //for(num <- arr3 if num%2==0) println("this num is even: " + num)

  arr3.exists(_ > 4)
  arr3.forall(_ < 4)

  arr1.reduceLeft(_ + _)

  arr1.foldLeft("0")(_ + _)


  arr1.find(_ > 1).map(_ * 2)

  case class Email(subject: String,
                   text: String,
                   sender: String,
                   recipient: String)

  type EmailFilter = Email => Boolean

  def newEmailsForUser(emails: Seq[Email], filter: EmailFilter) = emails.filter(filter)

  val sentByOneOf: Set[String] => EmailFilter = senders => email => senders.contains(email.sender)
  val notSendByAnyOf: Set[String] => EmailFilter = senders => email => !senders.contains(email.sender)


  type SizeChecker = Int => Boolean

  val sizeConstraint: SizeChecker => EmailFilter = f => email => f(email.text.size)

  val minSize: Int => EmailFilter = limit => sizeConstraint(_ >= limit)
  val maxSize: Int => EmailFilter = limit => sizeConstraint(_ <= limit)

  val mails = Email(
    subject = "It's me again, your stalker friend!",
    text = "Hello my friend! How are you?",
    sender = "dear.andras@gmail.com",
    recipient = "dear.balazs@gmail.com") :: Nil

  val sendByFilter: EmailFilter = sentByOneOf(Set("alma@gmail.com", "dear.andras@gmail.com"))
  val notSendByFilter: EmailFilter = notSendByAnyOf(Set("alma@gmail.com", "dear.andras@gmail.com"))


  val filteredEmails = newEmailsForUser(mails, sendByFilter)
  val filtered2Emails = newEmailsForUser(mails, notSendByFilter)

  def reverse[A](predicate: A => Boolean) = (a: A) => !predicate(a)

  val reverseSentByAnyOf = sentByOneOf andThen(g => reverse(g))

  val notSendByFilter2: EmailFilter = reverseSentByAnyOf(Set("alma@gmail.com", "dear.andras@gmail.com"))

  val filtered3Emails = newEmailsForUser(mails, notSendByFilter2)



}