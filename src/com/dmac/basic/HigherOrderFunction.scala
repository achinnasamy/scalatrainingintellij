package com.dmac.basic

object HigherOrderFunction {
  
  
  def main(args : Array[String]) : Unit = {
    
    println("Higher Order Function Executing")
    
    val capitalizer = new StringCapitalizerFunction
    println(capitalizer.stringCapitalizer("aaa"))
  }
}



class StringCapitalizerFunction {
  
  def stringCapitalizer(inputString : String) = {
    inputString.toUpperCase()
  }
}