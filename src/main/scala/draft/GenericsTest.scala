package draft

object GenericsTest extends App {

  class Stack[T] {
    var elements: List[T] = Nil

    def push(x: T) = elements = x :: elements

    def top(): T = elements.head

    def pop() = elements = elements.tail
  }

  val stack = new Stack[Int]

  stack.push(1)
  stack.push(2)
  stack.push(3)

  println(stack.top())
  stack.pop()
  println(stack.top())
  stack.pop()
  stack.push(4)
  println(stack.top())

}
