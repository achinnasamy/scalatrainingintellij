package com.dmac.basic

object RememberingThe_Operator extends App {
  
  // _ in the import refers to * as in Java
  // import java.io._
  
  // In assignment, it refers to default.
  var stringDefault    : String   = _
  var integerDefault   : Int      = _
  var floatDefault   : Float      = _
  var doubleDefault   : Double    = _
 
  println(integerDefault) // 0
  println(stringDefault) // null
  println(floatDefault) // 0.0
  println(doubleDefault) // 0.0 

  var i=1
  while (i < 10) {
    i+= 1
    println(i)
  }
  
  class Inner {
    
  }
}

class Outer