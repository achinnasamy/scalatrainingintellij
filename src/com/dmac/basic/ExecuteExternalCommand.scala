package com.dmac.basic

import sys.process._

object ExecuteExternalCommand extends App {
  
  System.setProperty("", "")
  val l = Process("ls")
  //val LS_COMMAND = "ls -l" !!
  
  println(l !!)
}