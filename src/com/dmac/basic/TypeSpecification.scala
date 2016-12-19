package com.dmac.basic

import scala.collection.mutable.Map

object TypeSpecification {
  

  
  def main(args : Array[String]) {
    
   val auaName = "S"
   
   val aInteger :  TypeAlias.MY_INTEGER = 5
   val aString : TypeAlias.myString = "Zeus"
   
   val empBean : TypeAlias.EMPBEAN = new EmployeeBean
   
  }
}

/**
 * Type Alias
 */
object TypeAlias {
  
  type MY_INTEGER = Int
  type myString = String
  type RT = Runtime
  type EMPBEAN = EmployeeBean
  
 
  type AuaCodeMap = Map[Int, String]
  
  def retrieveAUAFromSchema(auaName : String) : Unit = {

    
    
  }
}


/**
 *   Abstract Type
 **/
class AbstractTypeElucidation[Parent] {
  
  
}
