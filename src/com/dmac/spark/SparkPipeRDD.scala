package com.dmac.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 17/4/17.
  */
object SparkPipeRDD extends App {


  val config = new SparkConf
      config.setAppName("WordCountJOB")
      config.setMaster("local[8]")

  val sc = new SparkContext(config)

  val data = List("w")
  val dataRDD = sc.parallelize(data)

  val output = dataRDD.pipe("ls -l").collect();
  output.foreach(x => println(x))


}
