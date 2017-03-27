package com.dmac.basic

/**
  * Created by dharshekthvel on 22/3/17.
  */
object SimpleMapTransformation extends App {




//  val myList = List("IBM",
//                    "IS",
//                    "DOING",
//                    "GOOD")
//
//  val mappedIBMDTO = myList.map(eachLine => IBMDataCarrier(eachLine, eachLine.length))
//  //mappedIBMDTO.foreach(x => println(x))
//
//
//  val fileFactorys = new FileFactorys
//
//  val data = fileFactorys.getMeIBMDTO(1)
//
//  println(data.get)


}

case class IBMDataCarrier(name : String, lengthOfNames : Int)

sealed class FileFactorys {

  def getMeFile() : Unit = {

  }

  def getMeIBMDTO(sw : Int) : Option[IBMDataCarrier] = {

    if (sw == 1) Some(IBMDataCarrier("IBM_STATIC_DATA", 999))
    else None

  }
}
























//  myList.map(eachString => IBMDataCarrier(eachString, eachString.length))
//        .foreach(eachDTO => println(eachDTO.lengthOfName))
//
//
//  val xmlFactory = new XMLFactory
//  val result = xmlFactory.readIBMDTO(1)
//
//  println(result.get)


/*
class XMLFactory {

  def readXML(): Unit = {

  }

  def readIBMDTO(sw : Int) : Option[IBMDataCarrier] = {
    if (sw == 1) Some(IBMDataCarrier("IBM_STATIC_DATA", 1))
    else None
  }
}



case class IBMDataCarrier(name : String, lengthOfName : Int)
*/