package com.dmac.spark

import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql._

/**
  * Created by dharshekthvel on 10/16/16.
  *
  *
  **
  *
  *Structured Streaming is a fast and fault tolerant streaming which gurantees end-to-end exactly once stream processing.
  *Structured streaming is a fault tolerant engine built on top of Spark SQL engine.
  *The Dataset and DataFrame API's are used to process it.
  *
  */
object StructuredStreamingMultiplier extends App {






  val sparkSession = SparkSession.builder()
                                   .appName("StructuredStreamingMultiplierJOB")
                                      .master("local[*]")
                                     .getOrCreate()

  /*  eachLine Stream is the Input Table */
  val eachLineStream = sparkSession.readStream.format("socket")
    .option("host","localhost")
    .option("port","4567")
    .load()

  import sparkSession.implicits._


  // Result Table
  val eachRow  = eachLineStream.as[String].map(Integer.parseInt(_) * 3)

  // Result Table
  //val count = eachRow.groupBy("value").count();

  /*

  Complete Mode


  Append Mode


  Update Mode



   */


  /*      */
  val finalReckoner  = eachRow.writeStream.outputMode("append").format("console").start()

  System.out.println("Query ID "              + finalReckoner.id)
  System.out.println("Query Name "            + finalReckoner.name)
  System.out.println("Query Explain "         + finalReckoner.explain())
  System.out.println("Query exception "       + finalReckoner.exception)
  System.out.println("Query source status "   + finalReckoner.status)
  System.out.println("Query sink status "     + finalReckoner.lastProgress)

  finalReckoner.awaitTermination()

}
