package com.dmac.basic

object ValueClasses extends App {
  
  val dollar = new Dollar(100)
  println(dollar)
  
  val d = Dollar
  println(d)
  
}

class Dollar(val value: Float) extends AnyVal {
  
  override def toString = value.toString
}

/**
 * A Companion Object in the Same Name
 */
object Dollar {
  override def toString = {
    val s = new Dollar(1)
    s.toString()
  }
}