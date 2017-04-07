package org.sclot.plotconfig
import org.sclot.dataset.Dataset
import org.sclot.geometric_object.GeometricObject
import org.sclot.aesthetic.AestheticMapping

case class PlotConfig(data:Dataset,mapping:AestheticMapping,objects:Seq[GeometricObject]) {

}