package com.dmac.dv

import com.dmac.basic.CompanionObject

/**
  * Created by dharshekthvel on 21/3/17.
  */
object IBMFirsts extends App {

  val listOfAUA = List("Bangalore", "Chennai" ,"Coimbatore")


  //Functional Literal
  listOfAUA.drop(1)
           .foreach(x => println(x))

  val valueDTO = ValueDTO("EEE", 1)
  valueDTO.id = 9




  val c = new ClassConstructor("HELLO")
  println(c.getName())

  val ob = Cons("")

  val ds = DataStructure("HASHMAP")
  ds.get()


}

case class ValueDTO(var name : String, var id : Int)

