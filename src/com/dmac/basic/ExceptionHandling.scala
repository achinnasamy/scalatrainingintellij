package com.dmac.basic

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

object ExceptionHandling extends App {
  
  val eh = new ExceptionHandler
  
   try {
      eh.methodThrowsAException
      
    }
    catch {
      case ex: FileNotFoundException  => { println("File Not Found " + ex.getMessage)  }
      case ex: IOException            => { println("IO Exception " + ex.getMessage) }
      case ex: IllegalStateException  => { println("Message - " + ex.getMessage) }
    }

}


class ExceptionHandler {
  
  
  def readAFile() = {
    
    try {
      val f = new FileReader("input.txt")
      
    }
    catch {
      case ex: FileNotFoundException => {
        println("File Not Found " + ex.getMessage)
      }
      case ex: IOException => {
        println("IO Exception " + ex.getMessage)
      }
    }
    finally {
       println("Executing in finally")
    }
    
  }
  
  def methodThrowsAException() = {
    
    
    //val f = new FileReader("input.txt") 
    throw new IllegalStateException("Illegal Argument")  
    
  }
  
}