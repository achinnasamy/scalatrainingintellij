package com.dmac.spark

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming._

/**
  *
  * @author Chinnasamy (chinnasamyad@gmail.com)
  */
object SparkScalaSingle extends App {

  val sparkSession = SparkSession .builder()
    .appName("SparkJOB")
    .master("local")
    .config("spark.driver.allowMultipleContexts", "true")
    .getOrCreate

  val sparkContext = sparkSession.sparkContext

  /***********************  Multiple Spark Session  *******************************/
  //  val sparkSession1 = SparkSession .builder()
  //    .appName("SparkJOB")
  //    .master("local")
  //    .config("spark.driver.allowMultipleContexts", "true")
  //    .getOrCreate
  //
  //  val sparkContext1= sparkSession.sparkContext

  /***********************  Multiple Spark Session  *******************************/




  //  sparkContext.textFile("file:///home/aad-pc1/insurance.csv")
  //    .map(x => (x.split(",")(0),x.split(",")(1)))
  //    .saveAsSequenceFile("file:///home/aad-pc1/insurance_sequence.csv")


  //("file:///home/aad-pc1/insurance_text_file.csv")



  //  val sparkPrinter = new SparkPrinter

  //
  //  sparkContext.textFile("file:///home/aad-pc1/insurance.csv")
  //    .map(sparkPrinter.printEachLine)
  //    .collect()


  /**************************  PairRDD Creation  *************************/

  //    1. Using map()

    val pairRDD = sparkContext.textFile("file:////Users/dharshekthvel/ac//insurance.csv")
                              .map(x => (x.split(",")(0),x.split(",")(1)))
                              .foreach(x => println(x._1 + " " + x._2))



  //    2. Using keyBy()
  //               First key has the result of the function logic written inside the keyBy and the value has the original data.

  //    sparkContext.textFile("file:///home/aad-pc1/insurance.csv")
  //                        .keyBy((x) => x.split(",")(2))
  //                        .map(x => println(x._1) )
  //                        .collect()

  /**************************  PairRDD Creation  *************************/


  /**************************  PairRDD Action  *************************/
  /** PairRDD Actions - lookup(), collectAsMap(), countBykey() **/
  //  val out = sparkContext.textFile("file:///home/aad-pc1/insurance.csv")
  //                        .map(x => (x.split(",")(0),x.split(",")(1)))
  //                        .lookup("742303")
  //
  //  val out1 = sparkContext.textFile("file:///home/aad-pc1/insurance.csv")
  //                        .map(x => (x.split(",")(0),x.split(",")(1)))
  //                        .collectAsMap()
  //
  //  val out2 = sparkContext.textFile("file:///home/aad-pc1/insurance.csv")
  //                         .map(x => (x.split(",")(0),x.split(",")(1)))
  //                         .countByKey()

  //  println(out(0))
  //  println(out1)
  //  println(out2)

  /**************************  PairRDD Action  *************************/



  /********************************  Spark Streaming *********************************************/
  //  val sparkConfig = new SparkConf().setMaster("local[*]")
  //                                   .setAppName("StreamingJOB")
  //                                   .set("spark.driver.allowMultipleContexts", "true");
  //
  //  val streamingContext = new StreamingContext(sparkConfig, Seconds(1))
  //
  //  val eachStream = streamingContext.socketTextStream("localhost", 1234)
  //  eachStream.print()
  //
  //  streamingContext.start()
  //  streamingContext.awaitTermination()
  /********************************  Spark Streaming *********************************************/


  /*************************** Using the org.apache.spark.util.StatCounter object *****************/

  //    val rdd = sparkContext.parallelize(List(100,
  //                                            200,
  //                                            300,
  //                                            400,
  //                                            500))
  //
  //
  //    val max = rdd.stats().max
  //    val min = rdd.stats().min
  //    val mean = rdd.stats().mean
  //    val variance = rdd.stats().variance
  //
  //    println(min + " " + max + " " + mean + " " + variance)

  /*************************** Using the org.apache.spark.util.StatCounter object *****************/



  /***************** Class Declaration in Scala ************************************************/
  // The below all are legal in Scala

//  val sparkPrinterClassDeclaration = new SparkPrinter
//  val sparkPrinterClassDeclaration1 = new SparkPrinter()
//  val sparkPrinterClassDeclaration2 = new SparkPrinter();
//  val sparkPrinterClassDeclaration3 = new SparkPrinter;

  /***************** Class Declaration in Scala ************************************************/


}




class SparkPrinter {

  def printEachLine(eachLine : String) : String = {
    println(eachLine)
    eachLine
  }

}
