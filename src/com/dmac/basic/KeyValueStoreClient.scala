package com.dmac.basic

object KeyValueStoreClient {
  
  
  def main(arguments : Array[String]) : Unit = {
    
    println("Implementing KeyValueStore")
    
    val voldemort = new VoldemortKeyValueStore("voldemort_property")
    voldemort.put(1)
  }
}