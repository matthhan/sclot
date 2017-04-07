package org.sclot.aesthetic

trait AestheticMapping {
  def +(other:AestheticMapping):AestheticMapping
}

object AestheticMapping {
  implicit class MapAsAestheticMapping(map:Map[Aesthetic,String]) extends AestheticMapping {
    //TODO: implement
    def +(other:AestheticMapping):AestheticMapping = Map[Aesthetic,String]()
  }
}


