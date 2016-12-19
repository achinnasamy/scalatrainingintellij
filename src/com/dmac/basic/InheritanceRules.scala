package com.dmac.basic

object InheritanceRules extends App {
  
  tellMeWhomAmI(new CovariantFamily[Child] (new Child))
  
  invokeContravariant(new ContraVariantFamily[GrandParent])
  
  def tellMeWhomAmI(family : CovariantFamily[Parent]) {
     println(family.data.parentName)
  }
  
  
  def invokeContravariant(family : ContraVariantFamily[Parent]) {
     println("")
  } 

  
  val instance = new InstanceOF
  instance passInRef(new Child)
  
  
}

class CovariantFamily[+A] (val data : A)

class ContraVariantFamily[-T] {
  
  def method(a: T) {
    
  }
}


class InstanceOF {
  
  def passInRef(parent : Parent) {
    
    val child = parent.asInstanceOf[Child]
    println(child.childName)
    
  }
}