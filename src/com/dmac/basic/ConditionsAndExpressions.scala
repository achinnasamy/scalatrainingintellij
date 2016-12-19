package com.dmac.basic

import scala.util.control.Breaks

object ConditionsAndExpressions {
  
  
  def main(array : Array[String]) {
  
    val countries = List("INDIA", "RUSSIA", "CUBA", "CHINA")
    
    val forLoop = new ForLoop

    //forLoop.printTheArray(countries)
    
    // If there is only one parameter passed, then it can be accessed by the below means
    val isPrinted = forLoop printTheArray countries
    forLoop.printIntegers()
    
    /***** if...else ****/
    if (isPrinted) 
      println("Printed the Countries")
    else
      println("Not printed any of those")
    
    
    println(printMeManyTimes)
    
    
    forLoop.forLoopWithBooleanExpression
    
    forLoop forLoopWithYield
    
    var count = 0
    
    do {
      count+=1
      println("My count = " + count)
    }
    while(count < 10)
  }
  
  
  
  def printMeManyTimes() : String = {
    return "*" * 100
  }
}


class ForLoop {
  
  
  def printTheArray(listOfCountries : List[String]) : Boolean = {
    
    for (country <- listOfCountries) 
      println(country)
      
      false
  }
  
  
  def printIntegers() : Unit = {
    
    // Simple Loop
    for (i <- 1 to 10)
      println(i)
    
    val r = 100 to 1 by -1 // Reverse Printing
    println(r)
    
    val loop = new Breaks
    
    println("\n\n\n Reverse Printing")
    
    loop.breakable {
      for (i <- 50 to 1 by -1) {
        println(i)
        
        if (i==40)
          loop.break
      }
    }
    println("\n\n\n Reverse Printing - Ended")
    
    // Nested Loop
    for {  i <- 1 to 10 
             j <- 1 to 10 }
      println(i, j)
      
      
  }
  
  
  def forLoopWithBooleanExpression() {
    
    
    println("\n\n\n For Loop With Boolean Expressions")
    
    val authProperties = List ("AUA",
                               "ASA-Service Agency",
                               "TID",
                               "Version",
                               "UID",
                               "TXN",
                               "Encrypted-SKEY",
                               "Encrypted-SKEY-CertificateIdentifier",
                               "Data-Type",
                               "Data-Content-Encrypted-PID-XML",
                               "Encrypted-SKEY")
                               
    for (authElement <- authProperties if (authElement.startsWith("Data")))
      println(authElement)
      
  }
  
  def forLoopWithYield() = {
    
    val vectorList = Vector(1,2,3,4,5)
    
    val vectorReturn = for (element <- vectorList) yield element*2
    
    
    println(vectorReturn)
    
    
    val evenNumberMultiplier = for (element <- vectorList if (element % 2 == 0)) yield element*2
    println(evenNumberMultiplier)

    println(evenNumberMultiplier)
    
    val vectorReturn3 = if (vectorList.size == 5) vectorList else None
  }
  
  
}