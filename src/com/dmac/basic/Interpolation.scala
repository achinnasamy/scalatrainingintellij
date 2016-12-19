package com.dmac.basic

/**
 * String Interpolation
 */
object Interpolation {
  
  def main(appArguments : Array[String]) {
    
    val goldRate = 2400.34
    println(f"Todays gold rate = $goldRate")
        
    val exceptionMessage = "SLZ Zone Runtime Exception occurred"
    println(s"Exception message is : $exceptionMessage")   
    
  }
}