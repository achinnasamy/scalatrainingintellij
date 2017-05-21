package com.dmac.basic

import scala.io.Source
import scala.collection.mutable.ListBuffer

object FileOperations extends App {
  
  val fileOperations = new FileOperations
  //fileOperations.readFile("D:/ac/data/auth.txt")
  //fileOperations.readCSVFile("D:/ac/data/auth.txt")

  println (fileOperations.readFromURL())
}

case class AuthBean(val authCode:String, val auaCode : String)

class FileOperations {
  
  /**
   * Simple file read and printing it
   */
  def readFile(fileName: String) : Unit = {
    
    val file = Source.fromFile(fileName)
  
    for(line <- file.getLines())
      println(line)
      
    file.close
  }

  def readFromURL() : String = {
    val data = Source.fromURL("https://www.scala-lang.org/")
    data.getLines().mkString
  }
  
  def readCSVFile(fileName: String) : Unit = {
    
    val csvFile = Source.fromFile(fileName)
  
    val list = new ListBuffer[AuthBean]
    
    
    // Plain old way
    for(line <- csvFile.getLines()) {
        val lines = line.split(",")
        val ab = AuthBean(lines(0), lines(2))
        list += ab
    }
    
    
    // Functional way
    csvFile.getLines().foreach { line => 
                                         val column = line.split(",")
                                         val ab = AuthBean(column(0), column(2))
                                         list += ab
                               }
    
    val authBeanList = list.toList
    
    authBeanList.foreach { authBean => println(authBean.authCode) }
    csvFile.close
  }
  
  
  def writeFile(fileName: String) : Unit = {
    
  }
}