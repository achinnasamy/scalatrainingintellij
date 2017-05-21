package com.dmac.akka

import akka.actor.{ActorSystem, Props}

/**
  * Created by dharshekthvel on 11/5/17.
  */
object FileParserActor {


  def main(args : Array[String]) = {

    val actorSystem = ActorSystem.create("FileParserSystem")
    val fileReckonerActor = actorSystem.actorOf(Props[FileReckonerActors], "FileParserActor")


    fileReckonerActor ! "s-me"
    //fileReckonerActor ! DATAFile("xml")
  }
}
