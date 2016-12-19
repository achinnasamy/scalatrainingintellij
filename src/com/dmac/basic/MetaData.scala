package com.dmac.basic

object MetaData extends App {
  
  val clazz = classOf[ETMS]
  
  //for(methodName <- clazz.getMethods)
    //println(methodName)
    
  println(clazz.getName)
  println(clazz.getInterfaces)
  println(clazz.getConstructors)
}

trait AbstractTMS {
  
}
class ETMS(parameter : String) extends AbstractTMS{
  
  val appName = "Enterprise Trouble Management System";
  
  def getTotalTickets() : Int = {
    100
  }
}