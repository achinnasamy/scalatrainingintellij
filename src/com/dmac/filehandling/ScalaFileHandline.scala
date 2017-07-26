package com.dmac.filehandling

import java.io.{FileNotFoundException, IOException}
import java.util.logging.Logger
import java.util.logging.Level

import scala.io.Source

/**
  * Created by dharshekthvel on 30/6/17.
  */
object ScalaFileHandline {

  def main(args : Array[String]) = {

    val logger = Logger.getLogger("Logger")

    try {
      val file = Source.fromFile("/home/dharshekthvel/ac/code/scalatrainingintellij/data/sales.csv")

      val lines = file.getLines()
      val listOfLines = file.getLines().toList
      val listOfArray = file.getLines().toArray

      val completeString = file.getLines().mkString

      lines.foreach(each => println(each))

      file.close()
    }
    catch {
      case fofe : FileNotFoundException => logger.log(Level.CONFIG, fofe.getMessage)
      case ioe : IOException => logger.log(Level.CONFIG, ioe.getMessage)
    }

  }
}
