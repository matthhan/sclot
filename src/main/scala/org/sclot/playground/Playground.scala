package org.sclot.playground

import org.sclot.aesthetic.{Aesthetic, AestheticMapping, XAxis, YAxis}
import org.sclot.dataset.Dataset
import org.sclot.expressions.PlotExpression
import org.sclot.expressions.PlotExpressionImplementations._
import org.sclot.aesthetic.AestheticMapping._
import org.sclot.geometric_object.Point

object Playground extends App {
  val aesm= Map(XAxis() -> "hay",YAxis() -> "ho").asInstanceOf[AestheticMapping]
  Dataset("sampleData/blub.csv") + aesm + Point()
}
