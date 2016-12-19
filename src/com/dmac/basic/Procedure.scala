package com.dmac.basic

object Procedure {
  
  def todaysGoldRate(goldRate: Double) = println(f"Todays Gold Rate $goldRate")
    
  def logWarn(warningMessage : String) = println(s"Logging a warning message - $warningMessage") 
    
  // Also a Procedure can be represented by a bracket
  def logError(errorMessage : String) = {
      println(s"The errorMessage is $errorMessage")  
  }
  
  def logInfo(infoMessage : String) {
      println(s"The errorMessage is $infoMessage")  
  }
  
  def logger(message : String) : Unit = {
      println(s"The errorMessage is $message")
  }
  
  def main (arguments : Array[String]) : Unit = {
  
    todaysGoldRate(2390.78)
    logWarn("OOM may occur")
    logError("An Error occurred while instantiating HBASE")
    logInfo("Unable to hit voldemort. So persisting in redis")
    logger("MapR table cogent not found")
  }
  
}