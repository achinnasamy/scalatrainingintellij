package com.dmac.dv

import scala.io.Source


/**
  * Created by dharshekthvel on 11/10/16.
  */
object ThenAndComposePattern {

  def getCSVSplitted(input : String) : Array[String] = {
    input.split(",")
  }


  def returnCSVFormattedString(fileName : String) : String = {
    val file = Source.fromFile(fileName)
    file.getLines().mkString
  }

  def analyzeOntheData(inputArray : Array[String]) : Int = {
    inputArray(2).length
  }

  def main(args : Array[String]) = {

//
    val getMeData = getCSVSplitted _ compose  returnCSVFormattedString _ andThen analyzeOntheData _
    println(getMeData("/home/dharshekthvel/ac/code/scalatrainingintellij/data/titanic3.csv"))


    val convertStringToFloatUsingAndThen = convertStringToInt _ andThen convertIntToFloat _
    val convertStringToFloatUsingCompose = convertIntToFloat _ compose convertStringToInt _
    val mixOfComposeandThen = convertIntToFloat _ compose convertStringToInt _ andThen convertFloatToString _

    println(convertStringToFloatUsingCompose("20"))
    println(convertStringToFloatUsingAndThen("20"))
    println(mixOfComposeandThen("20"))

  }


  def convertStringToInt(input : String) : Int = {
    Integer.parseInt(input)
  }

  def convertIntToFloat(inputInteger : Int) : Float = {
    inputInteger.toFloat
  }

  def convertFloatToString(inputFloat : Float) : String = {
    inputFloat.toString
  }

}
