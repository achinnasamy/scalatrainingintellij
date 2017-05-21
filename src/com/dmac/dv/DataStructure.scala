package com.dmac.dv

/**
  * Created by dharshekthvel
  */
object DataStructure {
  def apply(name: String): DataStructure = {
    var ds = new DataStructure
    ds.set(name)
    ds
  }
}

class DataStructure() {
  var _name = ""
  def get() : String = {
    _name
  }
  def set(name : String) {
    _name = name
  }

  def toUpperCase(): Unit = {

  }
}