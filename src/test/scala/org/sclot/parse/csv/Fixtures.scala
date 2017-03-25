package org.sclot.parse.csv

object Fixtures {
  val trivial = "a,b\n5,7"
  val slightlyMoreComplicated = "x,y,z\n1,3.4,bla\n2,2.6,3\n -3,5,blub"
  val withWhitespace = "x, y,    z  \n 1, 2.  4, a alsdkfj\n 3  .5,7, alw 4"
  val nonRectangular1 = "x,y,z\n1,2"
  val nonRectangular2 = "x,y,z\n1,7\n3,5,2"
}
