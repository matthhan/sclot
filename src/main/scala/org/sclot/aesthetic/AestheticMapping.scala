package org.sclot.aesthetic

trait AestheticMapping
object AestheticMapping {
  implicit class MapAsAestheticMapping(map:Map[Aesthetic,String]) extends AestheticMapping
}


