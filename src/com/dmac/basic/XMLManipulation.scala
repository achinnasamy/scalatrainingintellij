package com.dmac.basic

import scala.io.Source

object XMLManipulation extends App {
  
  val processing = new XMLProcessing
  processing.parseTheXML
  
}


class XMLProcessing {
  
  def readTheXML() {


    val file = Source.fromFile("D:/ac/data/food.xml")
    val xmlFile = file.mkString
    
    println(xmlFile)
  }
  
  /*
   
   
    <breakfast_menu>
  	<food>
  		<name>Belgian Waffles</name>
  		<price>$5.95</price>
  		<description>Two of our famous Belgian Waffles with plenty of real maple syrup</description>
  		<calories>650</calories>
  	</food>
  	<food>
  		<name>Strawberry Belgian Waffles</name>
  		<price>$7.95</price>
  		<description>Light Belgian waffles covered with strawberries and whipped cream</description>
  		<calories>900</calories>
  	</food>
  	<food>
  		<name>Berry-Berry Belgian Waffles</name>
  		<price>$8.95</price>
  		<description>Light Belgian waffles covered with an assortment of fresh berries and whipped cream</description>
  		<calories>900</calories>
  	</food>
	
   */
  def parseTheXML() {
    
//    import scala.xml._
   
//    val file = XML.load("D:/ac/data/food.xml")
//    val food =  file \ "food" \ "name"
//
//    food.foreach { element => println(element.text) }
    
  }
  
}