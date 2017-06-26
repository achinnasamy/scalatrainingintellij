package com.dmac.basic

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by dharshekthvel on 2/5/17.
  */
object FutureElucidation {


  def main(args :Array[String]) = {

    println("Executing ...")
    //futureExecution
  }

  val futureExecution = Future {

    costlyOperation()
  }


  def costlyOperation() = {
    println("Costly operation done !!! ")
  }
}

