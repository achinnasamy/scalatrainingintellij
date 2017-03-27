package com.dmac.spark

import com.fasterxml.jackson.databind.deser.std.StringDeserializer
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}


/**
  * Structured Streaming
  * 
  * Created by dharshekthvel on 1/24/17.
  */
object SparkStreaming extends App {


    val sparkConf = new SparkConf()
    sparkConf.setAppName("StreamingJOB").setMaster("local[*]")

    val sparkContext1 = new SparkContext(sparkConf)

    val streamingContext = new StreamingContext(sparkContext1, Seconds(2))




}
