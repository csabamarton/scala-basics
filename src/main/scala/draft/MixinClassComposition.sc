object MixinClassComposition {

  abstract class AbstractIterator {
    type T
    def hasNext(): Boolean
    def next(): T
  }

  trait RichIterator extends AbstractIterator {
    def foreach(f: T => Unit): Unit = {
      while (hasNext()) f(next)
    }
  }

  class StringIterator(s: String) extends AbstractIterator {
    type T = Char
    private var i = 0

    override def hasNext() = i < s.length

    override def next(): T = {
      val char = s charAt i
      i += 1
      char
    }
  }

  class Iter extends StringIterator("alma") with RichIterator

  val iter = new Iter

  iter foreach println


}