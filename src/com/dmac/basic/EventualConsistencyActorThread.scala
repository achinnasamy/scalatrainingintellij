package com.dmac.basic

import akka.actor.{Actor, ActorSystem, Kill, Props, Stash}

/**
  * Created by dharshekthvel on 30/4/17.
  */
object EventualConsistencyActorThread {

  def main(args : Array[String]) = {

    val actorSystem = ActorSystem.create()
    val queueingActor = actorSystem.actorOf(Props[QueueingActor], "QueueingActor")

    queueingActor ! "queue"
    queueingActor ! "print"
    queueingActor ! "all"


    // Stopping an actor
    //queueingActor ! Kill

    queueingActor ! "shutdown"


  }

}


class QueueingActor extends Actor with Stash
{
  override def receive = {

    case "print" => println("printing ....")

    case "queue" => {
    //  unstashAll()
      stash()
    }
    // When you are done with a actor system: Call the terminate method to terminate the actor
    case "shutdown" => context.system.terminate()

    case _ => println("No stashing...")
  }
}