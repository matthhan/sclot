package org.sclot.aesthetic

case class AestheticMapping(val maps:(String,Aesthetic)*){
  //TODO ensure that each asthetic is only mapped to once
  def +(other:AestheticMapping):AestheticMapping = {
    AestheticMapping((this.maps ++ other.maps):_*)
  }
}

