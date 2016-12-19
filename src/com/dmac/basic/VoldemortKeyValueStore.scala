package com.dmac.basic

class VoldemortKeyValueStore(val keyStoreProperty : String) extends KeyValueStoreTrait {
    
  // Auxilary Constructor
  def this(propertyName : Int) = {
    this(propertyName.toString())
  }
  
  def get() : String = {
    return ""
  }
  
   def put(value : Any) : Boolean = {
     
     
     val recordInserted = true
     println(value)
     return recordInserted
   }
  
  
   override def dataStoreName(): String = {
      return "VOLDEMORT"
  }
}