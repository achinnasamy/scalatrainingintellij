package com.dmac.basic

/* An Object class using Trait */
object TraitRules extends App {
  
  val ocean = new OceanApp with Debugger
  ocean.printTrace("Tracing an error")

  // A trait can be instantiated in a anonymous way
  val debugger = new Debugger {

  }

  debugger printTrace "debugger trait anonimized"


  // A trait can be instantiated in a anonynous way.
  // But abstract methods has to be implemented.
  val machineLearning = new MachineLearning {
    override def supportVectorMachine(input: String) = {

    }
  }





}

/************************************************************************************/
class OceanApp {
  
}

trait Debugger {
  def printTrace(input : String) = {
    println(s"Tracing ... : $input")
  }
 
}
/************************************************************************************/

/************************************************************************************/
/* Abstract Class Extending Trait */
trait MachineLearning {
  
  var algorithmMarkedByUser = ""
  
  def regression(input : String) {
    println("Implementing Regression")
  }
  
  def supportVectorMachine(input : String) 
  
  def clustering(input: String) = {
    println("Implementing Clustering")
  }
}

abstract class H20 extends MachineLearning {
  def bayesianClassification(input : String) 
}


class MyClient extends H20 {
  
  def supportVectorMachine(input : String) = {
   // Concrete Implementation 
  }
  
  def bayesianClassification(input : String) = {
    // Concrete Implementation
  }

  def machineLearningProcessor(ml : MachineLearning) = {

  }
}
/************************************************************************************/

/************************************************************************************/
// A trait cannot have a constructor. While an abstract class can have a constructor

trait DatabaseOperationTrait { //(name : String) {
  def save
  def update
  def delete
}

abstract class AbstractDatabaseOperation(name:String) {
  
}

class MySQL(dataBaseName:String) extends AbstractDatabaseOperation(dataBaseName) {
  
}

/************************************************************************************/

trait ZeusTrait {
  def zeusMethod
}

trait SupremeTrait {
  def supremeMethod
}

trait SuperTrait {
  def superMethod() : String = {
    "SUPER_TRAIT"
  }
}

trait MyTrait extends SuperTrait 
                      with SupremeTrait with ZeusTrait {
  
}
/************************************************************************************/