package org.sclot.dataset
import scala.util.Try

sealed trait DataKind
case object Categorical extends DataKind
case object Integral extends DataKind
case object Numeral extends DataKind

object DataKind {
  def findKind(s:String): DataKind =
    if(Try(s.toInt).isSuccess) Integral else if (Try(s.toDouble).isSuccess) Numeral else Categorical
  def findBestKind(things:Seq[String]): DataKind = {
    val kinds = things.map(findKind)
    if(kinds.forall(klass => klass == Integral)) Integral
    else if(kinds.forall(kind => kind == Integral || kind == Numeral)) Numeral
    else  Categorical
  }
}

