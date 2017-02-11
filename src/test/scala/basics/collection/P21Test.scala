package basics.collection

import basics.collections.P21
import org.scalatest._

class P21Test extends FunSpec with GivenWhenThen with Matchers{
  describe("P21 problem") {

    it("should run locally") {

      Given("a pre-defined list")
      val origList = List('a, 'b, 'c, 'd)
      val newElement = 'new
      val insertPosition = 1

      When("try to insert the new element at the given position")
      val resultList = P21.insertAt(newElement, insertPosition, origList)


      Then("the transformation should be run on the integers")
      resultList should be (List('a, 'new, 'b, 'c, 'd))
    }
  }
}
