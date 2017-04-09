package org.sclot.geometric_object
import org.sclot.expressions.AtomicPlotExpression

sealed trait GeometricObject extends AtomicPlotExpression
case class Point() extends GeometricObject
