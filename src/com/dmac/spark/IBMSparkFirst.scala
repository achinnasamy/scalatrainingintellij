package com.dmac.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 22/3/17.
  */
object IBMSparkFirst extends App {

  val sparkConfig = new SparkConf
  sparkConfig.setAppName("IBMJOB")
  sparkConfig.setMaster("local[*]")

  val sparkContext = new SparkContext(sparkConfig)


  //transformation/covtype.info
  val textFileRDD = sparkContext.textFile("file:////home/dharshekthvel/ac/a.csv");
  textFileRDD.map(x => x)

  //action
  textFileRDD.foreach(x => println(x))

  sparkContext.stop()
}
