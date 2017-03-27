package com.dmac.spark

import java.util

import org.apache.spark.sql.SparkSession
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object SparkReadFile {

  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf()
    conf.setMaster("local[*]")
    conf.setAppName("BaseSparkJob")

    val sparkSession = SparkSession.builder()
              .appName("").master("").config("","").getOrCreate();

    val sc = sparkSession.sparkContext;


    val sparkContext = new SparkContext(conf)


    val rdd = sparkContext.parallelize(List(1,5,3,7,36,4,2,33,9), 4)
    val numberRDD = rdd.keyBy(x => x)

    val parRDD = numberRDD.mapPartitions(iter => {
         iter.toArray.sortWith((x, y) => x._1.compare(y._2) > 0).iterator
       },
       preservesPartitioning = true)

//    numberRDD.mapPartitionsWithIndex((index,iter) => {
//      println(index)
//      iter.toArray.sortWith((x,y) => println(x._1,y._1)).toIterator
//    })



    parRDD.foreach(x => println(x._1 + "---" + x._2))

//    val textFileRDD = sparkContext
//                        .textFile("/home/dharshekthvel/ac/code/scalatrainingintellij/data/auth.csv", 100)
//
//    val keyByRDD = textFileRDD.keyBy(eachLine => eachLine.split(",")(126))
//
//    val countByRDD = keyByRDD.countByKey()
//    val sortRDD = keyByRDD.sortByKey()
//    val groupByRDD = keyByRDD.groupByKey()
//
//    groupByRDD.foreach(x => println(x._1 + " ---- " + x._2))
//

    //
    //    val sortedRDD = numberRDD.sortByKey()
    //    sortedRDD.foreach(x => println(x._1 + "---" + x._2))


//    textFileRDD.getNumPartitions
//
//    val authenticationRDD = textFileRDD.map(eachLineRDD => AuthenticationDTO(eachLineRDD.split(",")(2),
//                                                     eachLineRDD.split(",")(85),
//                                                     eachLineRDD.split(",")(126)))
//
//
//
//
//    val filteredRDD = authenticationRDD.filter(eachRDD => {a.add(1);eachRDD.city.startsWith("Mumbai")})
//
//    authenticationRDD.filter(_.city.startsWith("Mumbai"))
//
//
//    filteredRDD.foreach(eachRDD => println( eachRDD.auaName + " - " + eachRDD.provider + " - " + eachRDD.city))
//
//    val aList = List("a", "b", "c")



//    val pairRDD = textFileRDD.keyBy(x => x.split(",")(126))















//
//    val countRDD = pairRDD.countByKey();
//    val sortRDD = pairRDD.sortByKey()
//    val groupedRDD = pairRDD.groupByKey()
//
//    groupedRDD.foreach(x => println(x._1 + " --- " + x._2))

    sparkContext.stop()




  }
}


case class AuthenticationDTO(auaName : String, provider : String, city : String)


class MyOwnDataPartitioner extends Partitioner {
  override def numPartitions: Int = numPartitions

  override def getPartition(key: Any): Int = ???
}










//val authenticationRDD = file.map(x => AuthenticationDTO(x.split(",")(2) , x.split(",")(85), x.split(",")(126)))
//
//val filteredRDD = authenticationRDD.filter(eachRDD => eachRDD.city.startsWith("Mumbai"))
//filteredRDD.foreach(eachRDD => println(eachRDD.auaName))

