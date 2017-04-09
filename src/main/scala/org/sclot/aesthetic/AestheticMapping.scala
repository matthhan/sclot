package org.sclot.aesthetic
import org.sclot.expressions.AtomicPlotExpression

case class AestheticMapping(val maps:(String,Aesthetic)*) extends AtomicPlotExpression {
  //TODO ensure that each asthetic is only mapped to once
  def +(other:AestheticMapping):AestheticMapping = {
    AestheticMapping((this.maps ++ other.maps):_*)
  }
}

