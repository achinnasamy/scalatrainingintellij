package com.dmac.basic

object ScalaMethods {
  
  
  
  def main(args : Array[String]) {
    val methodClass = new MethodClass
    println(methodClass.++("ARAVINDH "))
    println(methodClass ++ "ARAVINDH " )
    methodClass printAll
    
    println (methodClass +!@%%%%%%^&* "NAME")
    
    
    try {
      methodClass designByContract("")
    }
    catch {
      case ex : IllegalArgumentException => {
        println("Exception caught " + ex)
      }
    }
    
    
    val simpleList = List(1,2,3,4,5)
    
    // A Function Name as a Variable
    val functionNameAsVariable = (i:Int) => { i + 10}
    simpleList.map(functionNameAsVariable).foreach { x => println(x) }
    
  }
  
  
  
  
}

class MethodClass {
  
  /**
   		A Simple Function
   */
  def methodName(variableName : String) : Unit = {
    
  }
  
  /**
   * 
   */
  def printAll {
    
    println("The noble prize of computer science : ")
    println("Turing award")
  }
  
  
  /**
   * Methods names can be of symbols
   */
  def + (key : String, value : String) : String  = {
     key.concat(value)
  }
  
  def ++ (input : String) : String = {
    input.concat(input)
  }
  
  def +*-%^& (input : String) : String = {
    ""
  }
  
  def +!@%%%%%%^&* (input : String) : String = {
    "COMPLEX_NAMING"
  }
  
  
  def designByContract(member : String) {
    require(!member.isEmpty(), "MethodClass : member should not be empty")
  }
  /**
   
  		A Higher Order Function
  	
   */
  
  
  /**
   		A Partial Order Function
   */
  
  
  
  /**  
   		Currying Functions
   */
  
}