package com.dmac.dv

/**
  * Created by dharshekthvel on 11/10/16.
  */
object MapExample {


  def manipulationOnMap() = {


    val countryCode = collection.mutable.Map("IN" -> "India",
                                              "FR" -> "France")


    val retrieveCodeNotPresent = countryCode.get("US")
    val retrieveCodePresent = countryCode.getOrElseUpdate("US" , "UnitedStates")

    println(retrieveCodeNotPresent) // Will return None
    println(retrieveCodePresent) // Will return UnitedStates

  }
  def main(args : Array[String]) = {

    manipulationOnMap()
  }
}
