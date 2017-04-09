package org.sclot.expressions
import org.sclot.aesthetic.AestheticMapping
import org.sclot.dataset.Dataset
import org.sclot.geometric_object.GeometricObject
import org.sclot.plotconfig.PlotConfig


abstract class PlotExpression() {
  def +(other:PlotExpression) = CompoundPlotExpression(this,other)
  def evaluate():Option[PlotConfig]
}
case class CompoundPlotExpression(left:PlotExpression,right:PlotExpression) extends PlotExpression {
  def evaluate():Option[PlotConfig] = PlotExpressionEvaluator.evaluate(this)
}
trait AtomicPlotExpression extends PlotExpression {
  def evaluate():Option[PlotConfig] = None
}

