package org.sclot.playground

import org.sclot.aesthetic.{Aesthetic, AestheticMapping, XAxis, YAxis}
import org.sclot.dataset.Dataset
import org.sclot.expressions.PlotExpression
import org.sclot.expressions.PlotExpressionImplementations._
import org.sclot.aesthetic.AestheticMapping._

object Playground extends App {
  val aesm:AestheticMapping = Map(XAxis() -> "hay",YAxis() -> "ho")
  Dataset("sampleData/blub.csv").get + aesm
}
