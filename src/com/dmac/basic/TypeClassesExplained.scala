package com.dmac.basic

/**
  * Created by dharshekthvel on 26/6/17.
  */


// [0]	Define the type classes
final case class REDIS_NOSQL(data : String)

final case class VOLDEMORT_NOSQL(data : String)

final case class COUCHDB_NOSQL(datas: String)

// [1] 	Define Behavior
trait BigDataWriter[A] {

  def writeToDB(input : A)
}



// [2] 	Provide Implementation
object BigDataWriterUtility {


  implicit object MYSQLWriter extends BigDataWriter[REDIS_NOSQL] {
    override def writeToDB(input: REDIS_NOSQL) = {

      println(s"REDIS IS WRITTEN TO MYSQL $input")
    }
  }

  implicit class BigDataToDBConverter[A](input:A) {

    def writeToMYSQL(implicit writer : BigDataWriter[A]) = {
      writer.writeToDB(input)
    }
  }
}

object TypeClassesExplained extends App {


  import  BigDataWriterUtility._

  REDIS_NOSQL("key-value").writeToMYSQL

  //Error:(48, 6) could not find implicit value for parameter writer: com.dmac.basic.BigDataWriter[String]
  //"".writeToMYSQL

}



