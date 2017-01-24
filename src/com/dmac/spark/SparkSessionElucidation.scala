package com.dmac.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by dharshekthvel on 1/23/17.
  */
object SparkSessionElucidation extends App {


  val sparkSession = SparkSession.builder()
                                 .appName("SparkJOB").master("local[*]").config("spark.local.dir","/Users/dharshekthvel/ac")
                                 .getOrCreate()
  val sparkContext = sparkSession.sparkContext

  val file = sparkContext.textFile("/Users/dharshekthvel/ac/auth.csv")

  file.foreach(eachLine => println(eachLine))

  sparkContext.stop()
}
