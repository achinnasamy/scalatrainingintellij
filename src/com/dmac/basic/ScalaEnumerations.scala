package com.dmac.basic

object ScalaEnumerations extends App {
  
  for ( country <- CountryCode.values)
    println(s"$country" + " " +country.id)
    
  println(CountryCode.FRANCE)
}

object CountryCode extends Enumeration {
  
  type CountryCode = Value
  
  val INDIA  = Value("IN")
  val FRANCE = Value("FR")
  val RUSSIA = Value("RU")
  
}