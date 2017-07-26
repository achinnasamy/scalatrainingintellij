package com.dmac.aravindh

import org.apache.spark.{SparkConf, SparkContext}


/**
  * Created by dharshekthvel on 27/6/17.
  */
object ITCHelloWorld extends App {

  val sparkConfig = new SparkConf()
  sparkConfig.setAppName("ITCSparkJOB")
  sparkConfig.setMaster("spark://dharshekthvel:7077")

  val sparkContext = new SparkContext(sparkConfig)



  sparkContext.textFile("/home/a.txt")
    .flatMap(each => each.split(" "))
      .map(eachWord => (eachWord,1))
        .reduceByKey(_+_)
          .foreach(each => println(each._1 + each._2))


}


