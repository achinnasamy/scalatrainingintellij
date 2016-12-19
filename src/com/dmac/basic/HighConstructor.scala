package com.dmac.basic

object HighConstructor extends App {
 
  val oc = ObjectClass("Richard_Stallman")
  println(oc.getNameOfObject)
  
  
  val hc = new HighClass("HIGH_CLASS", 100)
  //hc.name = "HC" // Cannot assign to val
  hc.id = 999
  
  println(hc.name)
  println(hc.id)
  
  // Invoking auxillary constructor
  val hClass = new HighClass
  println(hClass name)
  println(hClass id)
  
  // Invoking auxillary constructor
  val clazz = new HighClass("ONE_ARG")
  println(clazz name)
  println(clazz id)
}

class HighClass(val name : String, var id: Int) {
  
  
  def this(name: String) {
   this(name, 88)  
  }
  
  def this() {
    this("_NO_ARG_")  
  }
  
}

/****************************************************************************/
// Create a constructor for the object class

class ObjectClass {
  
  private var objectName = ""
  
  def getNameOfObject() : String = {
    objectName
  }
}

object ObjectClass {
  
  def apply(name : String) : ObjectClass = {
    var objectClass = new ObjectClass
    objectClass.objectName = name
    objectClass
  }
}
/****************************************************************************/