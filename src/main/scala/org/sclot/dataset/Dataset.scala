package org.sclot.dataset
import org.sclot.parse.csv.CsvParser.parseCsv
import org.sclot.util.FileHandling.readStringFromFile
import org.sclot.expressions.AtomicPlotExpression

trait Dataset extends AtomicPlotExpression {
  def columns:Seq[Column]
  def size:Int
  def names:Seq[String]
}
object Dataset {
  def readFromCsvFile(path:String):Option[Dataset] = (readStringFromFile _ ).andThen(parseCsv)(path)
  def apply(x:String) = readFromCsvFile(x).get
}
