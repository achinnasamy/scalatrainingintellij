package com.dmac.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 23/3/17.
  */
object WordCountSpark extends App {

  val config = new SparkConf
              config.setAppName("WordCountJOB")
              config.setMaster("local[*]")

  val sc = new SparkContext(config)

  val sRDD = sc.textFile("file:////home/dharshekthvel/ac/docs/key-value.txt")
               .flatMap(_.split(" "))
               .map(eachWord => (eachWord, 1))
               .reduceByKey(_+_)
               .foreach(result => println(result._1 + " ---- " + result._2))






//  val reducedRDD = mappedRDD.reduceByKey(_+_)
//  reducedRDD.foreach(x => println(x._1 + " --- " + x._2))


//  sRDD.keyBy(x => x.length).foreach(x => println(x._1 + x._2))


//  val wRDD = sc.parallelize(List("Hey", "IBM", "IS", "FINE"))
//
//  val pairRDD = wRDD.map(x => (x, 1))
//
//  val reducedRDD = pairRDD.reduceByKey((x,y) => (x+y))
//
//  reducedRDD.foreach(x => println(x._1 + " --- " + x._2))


}
