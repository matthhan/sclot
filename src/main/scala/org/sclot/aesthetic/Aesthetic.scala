package org.sclot.aesthetic

sealed trait Aesthetic
class XAxis() extends Aesthetic
object XAxis { def apply() = new XAxis }
class YAxis() extends Aesthetic
object YAxis { def apply() = new YAxis }
class Shape() extends Aesthetic
object Shape { def apply() = new Shape }
class Color() extends Aesthetic
object Color { def apply() = new Color }

