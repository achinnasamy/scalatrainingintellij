package com.dmac.basic

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.SynchronizedMap


import scala.collection.parallel.mutable.ParArray
import scala.collection.parallel.mutable.ParHashMap
import scala.collection.parallel.mutable.ParMap
import scala.collection.parallel.mutable.ParSet
import scala.collection.parallel.mutable.ParSeq

import scala.collection.parallel.immutable.ParHashSet
import scala.collection.parallel.immutable.ParVector
import scala.collection.parallel.immutable.ParSet
import scala.collection.parallel.immutable.ParSeq


object CollectionClasses {
  
  
  def main(args : Array[String] ) : Unit = {
  
    
    
    /*
     * ********************** List ********************************
      	List - Simple Immutable List
     */
    val aadhaarPktState = List("PKT_REJECTED", 
                                "PKT_DUPLICATE",
                                "PKT_BIOMETRIC_STAGE_ABIS")
                                    
                          
    println(aadhaarPktState(1))
    
    for(i <- aadhaarPktState)
      println(i)

    aadhaarPktState.map((c:String) => println(c.size))
    
    
    val errorCodes = "200_OK" :: "404_BAD_REQUEST" :: "500_INTERNAL_SERVER_ERROR" :: "520_UNKNOWN_ERROR" :: Nil
    errorCodes.foreach { errorCode => println(errorCode)  }
    
    // List can also be of various data types
    val multiTypeList = List(500, "INTERNAL_SERVER_ERROR", true)
    
    val parallelMultiTypeList = multiTypeList.par
    
    val parallelArray = ParArray(1,2,3)
    val parallelHashMap = ParMap("key" -> "value")
    
    
    var mutableList = new ListBuffer[Int]()
    mutableList += 1
    
    
    /*******************************************************************/
    
    /*
     * ********************** Set ********************************
     	 Set is an immutable unordered collection of unique elements
     */
    

    println("\n\n\n Printing The Set")
    val setOfNumbers = Set(1,1,2,2,3,3)
    setOfNumbers.foreach { x => println(x) } // Prints 1,2,3 : Only unique elements
    
    // Converting a Immutable Set to Mutable Buffer
    var mutableSetBuffer = setOfNumbers.toBuffer 
    mutableSetBuffer += 100
    val immutableSet = mutableSetBuffer.toSet
    
    {

      import scala.collection.mutable.Set
      println("\n\n\n Printing The Mutable Set")
      val mutableSet = Set(1,2,2,3,3)
      mutableSet.add(4)
      mutableSet.foreach { x => println(x) }
      
    }
    
    
    /*******************************************************************/
    
    /*******************************************************************/
    // Map
    
    val cacheCleanerMap = Map(1 -> "AuaCacheCleaner",
                              2 -> "AsaCacheCleaner",
                              3 -> "ResidentDataCacheCleaner",
                              4 -> "LicenseCacheCleaner")
                       
     cacheCleanerMap.foreach(x => println(x._1 + x._2))
     
     // Converting a Immutable Map to Mutable Buffer
     var cacheCleanerBuffer = cacheCleanerMap.toBuffer
     cacheCleanerBuffer += (5 -> "")
     
     val immutableCacheCleanerMap = cacheCleanerBuffer.toMap
     
    /*******************************************************************/
    
    
     {
          println("\n\n\n Printing The Mutable Map")
          import scala.collection.mutable.Map    
          
          val cacheCleanerMutableMap = Map(1 -> "AuaCacheCleaner",
                                           2 -> "AsaCacheCleaner",
                                           3 -> "ResidentDataCacheCleaner",
                                           4 -> "LicenseCacheCleaner")
          cacheCleanerMutableMap += (5 -> "_END_")
          
          cacheCleanerMutableMap foreach(x => println(x._1 + x._2))
     }
      
    
      /** Mutable Stores **/
    
      // Uses List (Linked List) Internally
      val listBufferStore = collection.mutable.ListBuffer(1,2,3)
      
      // Uses Arrays Internally
      val arrayBufferStore = collection.mutable.ArrayBuffer(1,2,3)
      
      /**  Range **/
      val range10 = 1 to 10
      
      val range20 = 1 until 21
      
      println("\n\n\n Printing ranges : ")
      println(range10)
      println(range20)
      
      range20.foreach { element => println(element) }
      
      for (element <- range20)
        println(element)
    /*******************************************************************/
    // Tuple 
      
      val tupleStore = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,"17",18,19,20,21,22)
      println(tupleStore._22)
      
      val complexTuple = ("Insight into scala", 5, true)
      
    /*******************************************************************/
      
     val anArrayStore = Array(1,2,3,4,4,5,5)
     println("Element of an Array " + anArrayStore(6))
    
     anArrayStore.update(3, 99)
     anArrayStore :+ 999
     
     
     println("\n\n\n Printing Vector")
     val vectorStore = Vector(1, 2, 3, 4, "Last Element")
     val vectorStoreUpdated = 100 +: vectorStore :+ 999
     
     vectorStoreUpdated.foreach { x => println(x) }
     
  }
  
  // Parallel Collections
  
}



class SynchronizedCollectionMaker {
  
  import scala.collection.mutable.Map
  
  // DO NOT USE SynchronizedMap. Use Akka Actors
  def mapMaker() : Map[String, String] = {
    new HashMap[String, String] with SynchronizedMap[String, String]
  }
}