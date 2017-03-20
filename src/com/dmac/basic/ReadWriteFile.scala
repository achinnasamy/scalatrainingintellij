package com.dmac.basic

import java.io.FileReader
import java.io.FileNotFoundException
import scala.io.Source
//import scala.io.StdIn

/**
 * try - catch Exceptions
 */
object ReadWriteFile {
  
    def main(args : Array[String]) : Unit = {
      
          println ("Reading and Writing to File")
      
          try {
            
            val file = new FileReader("");
            file.close()
            
          }
          catch {
            case exception: FileNotFoundException => {
              println("Hey Chin - File is not found")
            }
          }
          finally {
              println("Executing Finally")  
          }
          
    }
    
    /**
     * Reading a File : The Scala way
     */
    def readingAFile(fileName : String) : Unit = {
      
      Source
            .fromFile(fileName)
            .foreach { print }
    }
    
    
    def readingFromKeyBoard() = {
      
//       val dataReadFromKeyboard = StdIn.readLine
//
//       println(dataReadFromKeyboard)
    }
}