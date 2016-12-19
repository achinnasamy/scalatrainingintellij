package com.dmac.basic

object OptionUsage {
  
  
  
  def main(args : Array[String]) {
    
    val optionClazz = new UsageOfOption
    val returnValue = optionClazz.divide(3.5, 9.0)
    
    
    println(returnValue.get)
    
    println(optionClazz.upperCaseLogger(null))
    
    val value = optionClazz.upperCaseLogger("logging  otp cache failure").get
    
    val someValue = optionClazz.upperCaseLogger("PARTIALLY_ACCEPTABLE")
    
    println("Some Value : " + someValue)
    //println(optionClazz.upperCaseLogger("logging  otp cache failure"))
    println(value)
  }
}


class UsageOfOption {
  
  val PA = new Some("PARTIALLY_ACCEPTABLE")
  
  @inline def divide(value : Double, divisor: Double) : Option[Double] = {
  
    if (divisor == 0) None
    else
    Option(value/divisor)
  }
  
  
  @inline def upperCaseLogger(inputText : String) : Option[String] = {
    
    if (inputText == null || inputText.isEmpty()) None
    //else if (inputText.equals(PA)) PA
    else {
      val message = "APP_NAME LOG : ".concat(inputText)
      Option(message) // This returns the Some internally
    
    }
  }
  
}