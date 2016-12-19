package com.dmac.basic

import scala.util.Random

object LazyEvaluation {
  
  def doExpensiveOperation() : Int = {
      println("Doing Expensive Operation")
      999
  }
  
  def main(args: Array[String]) {
      
    lazy val expensiveResource : Int = doExpensiveOperation
  
    
    
    val lazzy = new Lazzy
    
    //println(lazzy.randomX)
    //println(lazzy.randomVar)
    
    //println(lazzy.randomY)
    
    //lazzy.returnStream()
  }
}

class Lazzy {
  
  
  var randomVar = { println("Random Var"); Random.nextInt} 
  val randomX = { println("Random X"); Random.nextInt}
  
  lazy val randomY = { println("Random Y"); Random.nextInt()}
  
  /**
   * 
   */
  def returnStream() : Stream[AnyRef] = {
    val stream = Stream("Oracle", "DB2")
    
    val numberStream = Stream(1,2,3)
    numberStream.take(2).foreach { x => println(x) }
    
    return stream
  }
  
}