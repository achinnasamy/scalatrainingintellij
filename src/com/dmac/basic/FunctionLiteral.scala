package com.dmac.basic

object FunctionLiteral extends App {
  
  val sfl = new SimpleFunctionLiteral
  sfl.simpleFL
}

class SimpleFunctionLiteral {
  
  
  def simpleFL() {
    
    val complexQueing = List("QUEUE",
                             "TOPIC", "FANOUT", "_NO_QUEUE_");
    
    complexQueing.foreach { name => println(name) }
    //complexQueing.foreach ( new PrintingFunction().apply(queueName));
  }
}

class PrintingFunction extends Function1[String, String] {
  
  def apply(queueName: String) : String = {
    "WWW"
  }
}
