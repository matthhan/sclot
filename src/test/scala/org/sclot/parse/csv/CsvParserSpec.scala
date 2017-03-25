package org.sclot.parse.csv

import org.scalatest._
import org.sclot.dataset.{CategoricalColumn, IntegralColumn, NumeralColumn}

class CsvParserSpec extends FlatSpec with Matchers {
  "The CSV Parser" should "Exist" in {
    assert(CsvParser != null)
  }
  it should "Be able to parse a trivial example successfully" in {
    val parsed = CsvParser.parseCsv(Fixtures.trivial)
    assert(parsed.isDefined)
    assert(parsed.get.columns.length == 2)
    assert(parsed.get.size == 1)
  }
  it should "Be able to properly handle different types of values in the columns" in {
    val parsed = CsvParser.parseCsv(Fixtures.slightlyMoreComplicated)
    assert(parsed.isDefined)
    assert(parsed.get.columns.length == 3)
    assert(parsed.get.columns.size == 3)
    assert(parsed.get.columns.head.isInstanceOf[IntegralColumn])
    assert(parsed.get.columns(1).isInstanceOf[NumeralColumn])
    assert(parsed.get.columns(2).isInstanceOf[CategoricalColumn])
  }
  it should "Be able to handle csv with whitespace" in {
    val parsed = CsvParser.parseCsv(Fixtures.withWhitespace)
    assert(parsed.isDefined)
  }
  it should "reject csv which is not rectangular" in {
    val parsed1 = CsvParser.parseCsv(Fixtures.nonRectangular1)
    assert(!parsed1.isDefined)
    val parsed2 = CsvParser.parseCsv(Fixtures.nonRectangular2)
    assert(!parsed2.isDefined)
  }
}
