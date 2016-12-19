package com.dmac.basic

object CompanionObject extends App {
  
  val returnVal = FactoryMethod.execute
  println(returnVal)
}

// Companion class of the object 
class FactoryMethod {
  
  def executeSomeComplexBusinessLogic : String = {
    println("Execute Inside Factory Method")
    "executed_success"
  }
}

// Companion Object of the class FactoryMethod
object FactoryMethod {
  
  def execute() : String = {
    val fm = new FactoryMethod
    fm.executeSomeComplexBusinessLogic
  }
}