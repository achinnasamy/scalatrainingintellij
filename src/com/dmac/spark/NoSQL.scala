package com.dmac.spark

/**
  * Created by dharshekthvel on 2/15/17.
  */
object NoSQL extends App {


  def retrieveData(name : String, id: Int) : Option[MongoDBData]= {



    Option(MongoDBData(""))

  }


  val returnData = retrieveData("",101)

  if (returnData.isEmpty) {
    val data = returnData.get
    data

  }


}


case class MongoDBData(referential : String)
