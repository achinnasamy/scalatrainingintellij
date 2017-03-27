package com.dmac.dv

/**
  * Created by dharshekthvel on 21/3/17.
  */
class ClassConstructor(name : String, i : Int) {

  def this(ename : String) = {
    this(ename, 100)
  }

  def getName() : String = {
    name
  }
}


object Cons {

  var _name = ""
  def apply(name : String): Unit = {
    _name = name
  }

  def getName() : String = {
    _name
  }

}
