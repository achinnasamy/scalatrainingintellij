//package com.dmac.basic
//
//import akka.actor.ActorSystem
//import akka.actor.Actor
//import akka.actor.Props
//import com.dmac.basic.childPackage.ChildClass
//
//
//object ConcurrentApp  {
//
//
//  def main(args : Array[String]) : Unit = {
//
//    val system = ActorSystem("ConcurrentApp")
//    val sender = system.actorOf(Props[Receiver], "receiver")
//
//
//    sender ! "MESS"
//
//    sender.tell("MESS", sender)
//    val messageBean = Bean("bean")
//    sender.tell(messageBean, sender)
//    println(2)
//  }
//
//}
//
//class Receiver extends Actor {
//  def receive = {
//    case "MESS" => println("message is received")
//
//    case Bean(name) => println(s"Got it $name")
//    case _ => println("_DEFAULT_")
//
//  }
//}
//
//case class Bean(name : String)