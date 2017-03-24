package org.sclot.dataset
trait Dataset {
  def columns:Seq[Column[Value]]
  def rows:Seq[Row]
}
