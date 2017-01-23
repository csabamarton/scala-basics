package draft

import scala.collection.mutable

trait BasedWriter {
  def write(number: Int): Unit = {}
}

trait SimpleWriter extends BasedWriter {
  override def write(number: Int): Unit = println(number)
}

trait BufferWriter extends BasedWriter {
  var buffer = mutable.Buffer[Int]()

  override def write(number: Int): Unit = {
    buffer += number

    if (buffer.size > 5) {
      for (j <- buffer) super.write(j)
      buffer.clear()
    } else {
      println("Buffering " + number)
    }
  }
}

trait BinaryWriter extends BasedWriter {
  override def write(number: Int): Unit = super.write(number.toBinaryString.toInt)
}

object WriterInherintanceTest extends App {
    val bufBinPrint = new SimpleWriter with BinaryWriter with BufferWriter
    bufBinPrint.write(1)
    bufBinPrint.write(2)
    bufBinPrint.write(3)
    bufBinPrint.write(4)
    bufBinPrint.write(5)
    bufBinPrint.write(6)
}
