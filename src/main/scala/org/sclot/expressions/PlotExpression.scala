package org.sclot.expressions
import org.sclot.aesthetic.AestheticMapping
import org.sclot.dataset.Dataset
import org.sclot.geometric_object.GeometricObject


sealed abstract class PlotExpression() {
  def +(other:PlotExpression) = CompoundPlotExpression(this,other)
}
case class CompoundPlotExpression(left:PlotExpression,right:PlotExpression) extends PlotExpression
trait AtomicPlotExpression extends PlotExpression

object PlotExpressionImplementations {
  implicit class DatasetAsPlotExpression(d:Dataset) extends AtomicPlotExpression
  implicit class AestheticMappingAsPlotExpression(m:AestheticMapping) extends AtomicPlotExpression
  implicit class GeometricObjectAsPlotExpression(o:GeometricObject) extends AtomicPlotExpression
}
