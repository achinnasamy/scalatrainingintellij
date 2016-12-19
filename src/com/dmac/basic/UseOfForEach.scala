package com.dmac.basic

object UseOfForEach {
  
  def main(args: Array[String]) : Unit = {
     
    val clazz = new ForEachClass
    
    val names = Array("ALAN", "MATHISON", "TURING")
    
    //clazz.printArray(names)
    clazz printArray names
  }
}


class ForEachClass {
  
  def printArray(namesArray : Array[String]) : Unit = {
    namesArray.foreach { x => println(x) }
    
    namesArray.map { x => ??? }
  }
}