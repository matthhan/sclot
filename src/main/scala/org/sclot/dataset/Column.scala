package org.sclot.dataset
trait Column[T] {
  def values:Seq[T]
}
