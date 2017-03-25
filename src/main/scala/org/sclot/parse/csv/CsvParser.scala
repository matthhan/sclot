package org.sclot.parse.csv
import org.sclot.dataset.{Column, ColumnarDataset, Dataset}

import scala.util.Try

object CsvParser {
  def parseCsv(csv:String):Option[Dataset] =
    Try(csv.split('\n').map(_.split(',').map(_.trim)).transpose).toOption
      .flatMap(discardIfUnequalLength)
      .map(in => ColumnarDataset(in.map(Column.fromStrings(_))))
  private def discardIfUnequalLength(in:Array[Array[String]]) = if(in.map(_.length).distinct.length == 1) Option(in) else None

}
