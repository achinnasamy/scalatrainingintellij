package com.dmac.spark

import org.apache.spark.sql.SparkSession

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
object StructuredStreaming extends App {



  val sparkSession = SparkSession.builder()
                                   .appName("StructuredStreamingJOB")
                                      .master("local[*]")
                                     .getOrCreate()

  /*  eachLine Stream is the Input Table */
  val eachLineStream = sparkSession.readStream.format("socket")
    .option("host","localhost")
    .option("port","4567")
    .load()


  /*

  Complete Mode


  Append Mode


  Update Mode



   */
  /*      */
  val finalReckoner  = eachLineStream.writeStream.outputMode("append").format("console").start()
  finalReckoner.awaitTermination()


}
