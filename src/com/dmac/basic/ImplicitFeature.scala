package com.dmac.basic

object ImplicitFeature {
  
  implicit val floatValue = 167f
  
  def printAge(implicit name : String) {
    println(s"printing age of $name")
  }
  
  implicit def getName(age : Int) : String = {
    println("obtaining name")
    "CHINNASAMY"
  }
  
  
  def getMeRoundedNumberOfFloat(implicit anyFloatValue : Float) {
    println(anyFloatValue)  
  }
  
  /* Two implicit functions cannot be possible 
  implicit def getName(age: Int) : String = {
    ""
  } */
  
  def main(args: Array[String]) {
    printAge(12)
    
    getMeRoundedNumberOfFloat 
  }
  
}