package org.sclot.playground

import org.sclot.aesthetic.{Aesthetic, AestheticMapping, XAxis, YAxis}
import org.sclot.dataset.Dataset
import org.sclot.expressions.PlotExpression
import org.sclot.expressions.PlotExpressionImplementations._
import org.sclot.aesthetic.AestheticMapping._
import org.sclot.geometric_object.Point

object Playground extends App {
  val expr = Dataset("sampleData/blub.csv") + AestheticMapping("hay" -> XAxis(), "ho" -> YAxis()) + Point()
  println(expr.evaluate())

}
