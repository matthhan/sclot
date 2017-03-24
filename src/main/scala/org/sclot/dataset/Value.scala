package org.sclot.dataset

sealed trait Value

object ValueTypes {
  implicit class IntegerAsValue(v:Int) extends Value
  implicit class DoubleAsValue(v:Double) extends Value
  case object Categorical extends Value
}
