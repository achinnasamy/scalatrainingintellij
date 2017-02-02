package com.dmac.spark

import java.util

import org.apache.spark.{SparkConf, SparkContext}

object SparkReadFile {

  def main(args: Array[String]) : Unit = {
    
    println("Spark Read File - Chinnasamy")

    val conf = new SparkConf()
    conf.setMaster("local[*]")
    conf.setAppName("BaseSparkJob")

    val sparkContext = new SparkContext(conf)
    val file = sparkContext.textFile("/Users/dharshekthvel/ac/auth.csv")


    file.foreach(eachLine => println(eachLine))

    sparkContext.stop()

    
    
  }
}