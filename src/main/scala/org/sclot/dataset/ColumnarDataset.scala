package org.sclot.dataset
case class ColumnarDataset(_columns:Seq[Column]) extends Dataset {
  override def columns: Seq[Column] = this._columns
  override def names: Seq[String] = this.columns.map(_.name)
  override def size: Int = this.columns.head.size
}
