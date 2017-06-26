package com.dmac.spark

import com.dmac.dv.DataStructure

/**
  * Created by dharshekthvel on 2/15/17.
  */
object IBM {


  def main(args : Array[String]) = {
    println("IBM")


    val variable = Set(1,2,3)

    val vectorVar = Vector(1,2,"RR",3,4,5)

    val range1 = 1 to 10
    val range2 = 1 until 10
    val range3 = 1 to 10 by 4

    'a' to 'z' by 4

    for (each <- vectorVar)
      println(each)

    for (each <- 0 to 3)
      vectorVar(each)



    // 22
    val varTuple = (1,2,3,4,56,7)

    for (i <- vectorVar)
      println(i)

    for ( i <- 0 to 3)
      println(vectorVar(i))













    val countryMap = Map(1 -> "IN", 2 -> "US", 3->"SL")


    val petaApp = new PetaApp

    petaApp lazzyInitialized
  }
}

class PetaApp {

  val randomizeData = {
    println("Initialized...")
  }

  lazy val lazzyInitialized = {
    println("Lazy Initialization")
  }
}