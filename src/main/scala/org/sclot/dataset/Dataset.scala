package org.sclot.dataset
trait Dataset {
  def columns:Seq[Column]
  def size:Int
  def names:Seq[String]
}
