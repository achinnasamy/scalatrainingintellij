package com.dmac.basic

import com.dmac.basic.parentpackage.PublicClass
import com.dmac.basic.parentpackage.ChildClass


object VisibilityScopes extends App {
  
  val pc = new ChildClass
  pc.printer
}



package parentpackage {
  
  class PublicClass {
    
    private                   val    privateValue           = 22
    
    protected                 val    protectedValue         = 33
    
    private[parentpackage]    val    privatePackageScoped   = 44
    
    private[PublicClass]      val    privateClassScoped     = 55
    
    protected[PublicClass]    val    protectedClassScoped   = 66 
  }
  
  class ChildClass extends PublicClass {
    
    def printer () {
      println(this.protectedValue)
      println(this.privatePackageScoped)
      println(this.protectedClassScoped)
    }    
  }
}



package childPackage {
  
  class ChildClass extends PublicClass {
   def printer () {
    println(this.protectedValue)
    println(this.protectedClassScoped)
   }
  }
}