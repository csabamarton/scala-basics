object SyntacticSugar {

  def myWhile(cond: => Boolean)(body: => Unit):Unit = {
    if(cond) {
      body
      myWhile(cond)(body)
    }
  }

  var i = 0
  myWhile(i < 5) {
    println(i)
    i += 1
  }
}