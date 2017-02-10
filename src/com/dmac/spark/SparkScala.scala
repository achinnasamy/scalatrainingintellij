package com.dmac.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 1/29/17.
  */
object SparkScala extends App {


  val sparkConfig = new SparkConf()
                              sparkConfig.setAppName("SparkJOB")
                              sparkConfig.setMaster("local[*]")


  val sparkContext = new SparkContext(sparkConfig)


  val auaCodeBroadCast = sparkContext.broadcast(AUACodeEnum("9999999"))
  val countAccumulator = sparkContext.longAccumulator("Counter")


  val textFileRDD = sparkContext.textFile("/Users/dharshekthvel/ac/auth.csv");

//  textFileRDD.map(eachLine => eachLine.split(","))
//              .foreach(eachLine => println(eachLine(0)))

  val authDTORDD = textFileRDD.map(eachLine => eachLine.split(","))
              .map(eachLine => AuthDTO(eachLine(0), auaCodeBroadCast.value.name))

  authDTORDD.map(eachRDD => {println(eachRDD.aua); countAccumulator.add(1L)}).collect()

  println(countAccumulator.value)

}

case class AuthDTO(authCode : String, aua : String)
case class AUACodeEnum(name : String)