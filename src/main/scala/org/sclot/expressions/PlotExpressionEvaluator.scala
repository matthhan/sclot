package org.sclot.expressions
import org.sclot.plotconfig.PlotConfig
import org.sclot.geometric_object.GeometricObject
import org.sclot.aesthetic.AestheticMapping
import org.sclot.dataset.Dataset
import scala.reflect.ClassTag

object PlotExpressionEvaluator {
  def evaluate(expr:CompoundPlotExpression):Option[PlotConfig] = {
    val data = rightmostDataset(expr)
    val aesmap = findByType[AestheticMapping](expr).reduce((a,b) => a+b)
    val objects = findByType[GeometricObject](expr)
    if(data.isDefined) Option(PlotConfig(data.get,aesmap,objects)) else None
  }
  def findByType[T:ClassTag](expr:PlotExpression):Seq[T] =  expr match {
    case CompoundPlotExpression(left, right) => findByType[T](left) ++ findByType[T](right)
    case x: T => Seq(x)
    case _ => Seq()
  }

  def rightmostDataset(expr:PlotExpression):Option[Dataset] = expr match {
    case d:Dataset => Option(d)
    case CompoundPlotExpression(left,right) => if(rightmostDataset(right).isDefined) rightmostDataset(right) else rightmostDataset(left)
    case _ => None
  }
}
