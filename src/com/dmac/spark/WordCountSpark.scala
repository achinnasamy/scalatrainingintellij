package com.dmac.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 23/3/17.
  */
object WordCountSpark extends App {

  val config = new SparkConf
              config.setAppName("WordCountJOB")
              config.setMaster("local[4]")

  val sc = new SparkContext(config)

  val sRDD = sc.parallelize(List(1L,2L,3L))

  sRDD.stats()

  //val mappedRDD = sRDD.map(x => (x, 1))
//  val reducedRDD = mappedRDD.reduceByKey(_+_)
//
//  reducedRDD.foreach(x => println(x._1 + " --- " + x._2))





  val wRDD = sc.parallelize(List("Hey", "IBM", "IS", "FINE"))

  val pairRDD = wRDD.map(x => (x, 1))
//
//  val reducedRDD = pairRDD.reduceByKey((x,y) => (x+y))
//
//  reducedRDD.foreach(x => println(x._1 + " --- " + x._2))


}
