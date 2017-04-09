package org.sclot.dataset



abstract sealed class Column(val name:String) {
  def values:Seq[_]
  def size = values.size
}
class IntegralColumn(name:String, vals:Seq[Int]) extends Column(name) {
  def values: Seq[Int] = vals
}
class NumeralColumn(name:String, vals:Seq[Double]) extends Column(name) {
  def values: Seq[Double] = this.vals
}
class CategoricalColumn(name:String, vals:Seq[String]) extends Column(name) {
  def values:Seq[String] = vals
}
object Column {
  def fromStrings(strings:Seq[String]):Column = {
    val name = strings.head
    val vals = strings.tail
    val kindToUse = DataKind.findBestKind(vals)
    kindToUse match {
      case Integral => new IntegralColumn(name,vals.map(_.toInt))
      case Numeral => new NumeralColumn(name,vals.map(_.toDouble))
      case Categorical => new CategoricalColumn(name,vals)
    }
  }
}
