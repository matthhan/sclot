package org.sclot.parse.csv
import org.sclot.dataset.Dataset
import org.sclot.dataset.ArrayDataset

object CsvParser {
  def parseCsv(csv:String):Option[ArrayDataset] = {
    val splitup = csv.split('\n').map(_.split(','))
    val variableNames = splitup.head
    val body = splitup.tail
    val byColumn = new Array[Array[String]](body.head.length);
    (0 to byColumn.length-1).foreach (i => { 
      byColumn(i) = body.map { arr => arr(i) } 
    })
    return Option(ArrayDataset(variableNames,byColumn))
  }
}
