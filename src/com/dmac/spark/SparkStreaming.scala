package com.dmac.spark

import org.apache.spark.sql.SparkSession

/**
  * Structured Streaming
  * 
  * Created by dharshekthvel on 1/24/17.
  */
object SparkStreaming extends App {

  val sparkSession = SparkSession.builder()
                                 .appName("StreamingJOB")
                                 .getOrCreate()



}
