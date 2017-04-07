package org.sclot.expressions
import org.sclot.plotconfig.PlotConfig
import org.sclot.geometric_object.GeometricObject
import org.sclot.aesthetic.AestheticMapping
import org.sclot.dataset.Dataset

object PlotExpressionEvaluator {
  def evaluate(expr:CompoundPlotExpression):Option[PlotConfig] = {
    val data = rightmostDataset(expr)
    val aesmap = findAestheticMappings(expr).reduce((a,b) => a+b)
    val objects = findGeometricObjects(expr)
    if(data.isDefined) Option(PlotConfig(data.get,aesmap,objects)) else None
  }
  //TODO: implement
  def findAestheticMappings(expr:CompoundPlotExpression):Seq[AestheticMapping] = Seq()
  //TODO
  def findGeometricObjects(expr:CompoundPlotExpression):Seq[GeometricObject] = Seq()
  def rightmostDataset(expr:PlotExpression):Option[Dataset] = expr match {
    case d:Dataset => Option(d)
    case CompoundPlotExpression(left,right) => if(rightmostDataset(right).isDefined) rightmostDataset(right) else rightmostDataset(left)
    case _ => None
  }
}
