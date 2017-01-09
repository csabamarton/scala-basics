object HigherOrderMethods {

  val arr1 = Array.range(1, 5)
  val arr2 = Array.range(1, 9, 2)
  val arr3 = List.tabulate(6)(i => i+3)

  arr1.map(_*3)

  arr2.filter(_<9)

  arr1.flatMap(i => arr2.take(i))

  //for(num <- arr3 if num%2==0) println("this num is even: " + num)

  arr3.exists(_>4)
  arr3.forall(_<4)

  arr1.reduceLeft(_+_)

  arr1.foldLeft("0")(_+_)


  arr1.find(_>1).map(_*2)
}