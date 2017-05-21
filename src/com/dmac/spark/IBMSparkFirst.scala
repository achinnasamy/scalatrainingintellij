package com.dmac.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 22/3/17.
  */
object IBMSparkFirst extends App {


  val conf = new SparkConf()
  conf.setMaster("local[*]")
  conf.setAppName("BaseSparkJob")

  val sparkSession = SparkSession.builder()
    .appName("").master("").config("","").getOrCreate();

  val sc = sparkSession.sparkContext;


  val sparkContext = new SparkContext(conf)

  sparkContext.longAccumulator("")

}

