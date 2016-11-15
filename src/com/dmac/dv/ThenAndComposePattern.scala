package com.dmac.dv

/**
  * Created by dharshekthvel on 11/10/16.
  */
object ThenAndComposePattern {

  def getCSVSplitted(input : String) : Array[String] = {
    input.split(",")
  }


  def returnCSVFormattedString() : String = {
    return "a,b,c"
  }

  def main(args : Array[String]) = {


  }
}
