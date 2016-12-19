package com.dmac.basic

object ScalaClass {

  def main(args : Array[String]) {
  
    val csvReader = new CSVLogReader
    println(csvReader.readFileName())
    
  }
  
}



/**
 		Classes are the core building block of object-oriented languages.
 		A combination of data structures and functions.
 */
class CSVLogReader extends LogReader {
  
  override def readFileName() : String = {
    //"CSV_FILE"
    super.readFileName()
  }
}


class LogReader {
  
  def readFileName() : String = {
    val fileName = "SIMPLE_FILE_1"; fileName
  }
}