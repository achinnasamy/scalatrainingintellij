package com.dmac.spark

import com.fasterxml.jackson.databind.deser.std.StringDeserializer
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Encoders, SparkSession}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import parquet.format.Encoding


/**
  * Structured Streaming
  * 
  * Created by dharshekthvel on 1/24/17.
  */
object SparkStreaming extends App {

    val sparkSession = SparkSession.builder()
                                    .appName("SparkJOB")
                                    .master("local[*]")
                                    .config("spark.driver.allowMultipleComtext", "true")
                                      .getOrCreate()

    val csvReadDataFrame = sparkSession.sqlContext.read.csv("/home/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv")

    //csvReadDataFrame.show(100)
    //csvReadDataFrame.select("_c0").show(100)


    csvReadDataFrame.createTempView("IBM_AUTH_TABLE")
      //.createOrReplaceTempView()
      //.createTempView("IBM_AUTH_TABLE")


    sparkSession.sql("SELECT _c0 from IBM_AUTH_TABLE").show(100)


    val df = sparkSession.sqlContext
                            .read
                            .format("jdbc")
                            .options(Map("url" -> "",
                                         "user" -> "",
                                         "password" -> "",
                                         "dbtable" -> ""))
      .load()


    df.select("col_name").show(100)


    val list = List("a", "b", "c")

    list.map( eachObj =>  eachObj.toUpperCase)

    for (i <- list)
        i.toUpperCase


}
