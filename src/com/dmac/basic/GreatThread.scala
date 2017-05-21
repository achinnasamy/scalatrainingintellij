package com.dmac.basic

import java.util.concurrent.TimeUnit
import akka.actor.{Actor,ActorSystem, Props, ActorRef};
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.Await


object GreatThread extends App {

  val actorSystem = ActorSystem.create()
  val masterActor = actorSystem.actorOf(Props[Master], name = "Master")

  masterActor ! "MASTER-HIT"

  actorSystem.terminate()

//  val firstLaneActor = actorSystem.actorOf(Props[FirstLane], name = "FirstLane")
//
//  firstLaneActor ! "2"




//  val masterActor = actorSystem.actorOf(Props[Master], name = "MasterActor")
  //masterActor ! "MASTER-HIT"
  //masterActor ! 999


//  val workerOneActor = actorSystem.actorOf(Props[WorkerOne], name = "WorkerOneActor")
//  workerOneActor ! "TRIGGER-WORKER-ONE_SLAVE"

  //workerOneActor.tell("TRIGGER-SOME_ONE", null)

  // Ask for work
//  var futureWork = workerOneActor.ask("ASK-WORKER")
//
//  implicit val duration: Timeout = Timeout(20 seconds)
//
//  val result = Await.result(futureWork, duration.duration);
//
//  println(result)

//  val workerThree = actorSystem.actorOf(Props[WorkerThree], "WorkerThree")
//  workerThree ! "HIT-WORKER-THREE"
//  println("Executing before stop !")
//  workerThree ! "stop"
//  println("Executing after stop !")
}

class FirstLane extends Actor {

  def receive = {

    case "1" => println("First Lane")
    case _ => println("Default - In the First Lane")
  }
}


class Master extends Actor {

  def receive = {

    case "MASTER-HIT" => println("Received message in master")
    case 999 => println("Received message in master 999")
    case _ => println("Executing in master")
  }
}

class WorkerOne extends Actor {
  override def receive = {

    case message:String => {
      println("WorkerOne - Computing Message " + message + sender().path)



      if (message.equals("TRIGGER-WORKER-ONE_SLAVE")) {
        var workerOneSlave = context.actorOf(Props[WorkerOneSlave], "WORKER_ONE_SLAVE");
        workerOneSlave ! 100
      }


    }
    case _ => "In worker one...Default"
  }
}

class WorkerOneSlave extends Actor {
  override def receive = {

    case message => {
      println("WorkerOneSlave - Computing Message " + message + sender().path)

      sender() ! "I got your message. I am your slave...Computing..."
    }
    case _ => "In worker one..."
  }
}

class WorkerTwo extends Actor {

  override def receive = {

    case _ => "Computing on WorkerTwo"
  }
}


class WorkerThree extends Actor {

  override def receive = {

    case "HIT-WORKER-THREE" => println("Working on worker three !!!")
    case "stop" => {
      println("Stopping the thread - worker three...")
      context stop self

    }
    case _ => "Computing on WorkerThree"
  }
}





case class Message(id: Int, messageContent : String)