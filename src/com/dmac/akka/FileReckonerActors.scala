package com.dmac.akka

import akka.actor.{Actor, Stash}

/**
  * Created by dharshekthvel on 11/5/17.
  */
class FileReckonerActors extends Actor with Stash {

  def receive = {
    case DATAFile(fileName) => {
      println("got file..." + fileName)
      if (fileName.equals("xml")) context.become(xmlFileReckoner)
      else context.become(csvFileReckoner)

      self ! DATAFile(fileName)
    }
    case "s-me" => stash()
    case "us-me" => unstashAll()
    case _ => println("Parsed file done...")
  }

  def xmlFileReckoner : Receive = {
    case DATAFile(fileName) => {
      println("File is processed " + fileName)
      //context.unbecome()
    }
    case _ => println("XML file parsed")
  }

  def csvFileReckoner : Receive = {
    case _ => println("CSV File parsed")
  }

}


case class DATAFile(fileName : String)