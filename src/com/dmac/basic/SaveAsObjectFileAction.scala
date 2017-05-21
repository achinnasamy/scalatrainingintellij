package com.dmac.basic

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 20/4/17.
  */
object SaveAsObjectFileAction extends App {

  val sparkConfig = new SparkConf()

  sparkConfig.setAppName("SimpleSparkJOB")
  sparkConfig.setMaster("local[*]")
  //  sparkConfig.set("spark.driver.host", "localhost")

  val sparkContext = new SparkContext(sparkConfig)

  val textFileRDD = sparkContext.textFile("file:////home/dharshekthvel/ac/code/scalatrainingintellij/data/dataset.txt", 1)


  // Type casting at the the time of reading
  sparkContext.objectFile[Long]("")

}
