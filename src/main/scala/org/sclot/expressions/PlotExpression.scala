package org.sclot.expressions
import org.sclot.aesthetic.AestheticMapping
import org.sclot.dataset.Dataset
import org.sclot.geometric_object.GeometricObject
import org.sclot.plotconfig.PlotConfig


sealed abstract class PlotExpression() {
  def +(other:PlotExpression) = CompoundPlotExpression(this,other)
  def evaluate():Option[PlotConfig]
}
case class CompoundPlotExpression(left:PlotExpression,right:PlotExpression) extends PlotExpression {
  def evaluate():Option[PlotConfig] = None
}
trait AtomicPlotExpression extends PlotExpression {
  def evaluate():Option[PlotConfig] = None
}

object PlotExpressionImplementations {
  implicit class DatasetAsPlotExpression(d:Dataset) extends AtomicPlotExpression
  implicit class AestheticMappingAsPlotExpression(m:AestheticMapping) extends AtomicPlotExpression
  implicit class GeometricObjectAsPlotExpression(o:GeometricObject) extends AtomicPlotExpression
}
