package org.sclot.parse.csv

import org.scalatest._

class CsvParserSpec extends FlatSpec with Matchers {
  "The CSV Parser" should "Exist" in {
    assert(CsvParser != null)
  }
  it should "Be able to parse a trivial example" in {
    assert(CsvParser.parseCsv(Fixtures.trivial).isDefined)
  }
}
