package org.sclot.util

object FileHandling {
  def readStringFromFile(path:String):String = {
    val src = scala.io.Source.fromFile(path)
    val res = try src.mkString finally src.close()
    res
  }
}
