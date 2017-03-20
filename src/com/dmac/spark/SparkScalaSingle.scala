package com.dmac.spark

import org.apache.spark.{SparkConf, SparkContext}
//import org.apache.spark.mllib.clustering.KMeans
//import org.apache.spark.mllib.linalg.Vectors
//import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming._
//import org.apache.spark.streaming.kafka010.KafkaUtils
//import org.elasticsearch.spark.rdd.EsSpark

import scala.collection.mutable

/**
  *
  * @author Chinnasamy (chinnasamyad@gmail.com)
  */
object SparkScalaSingle extends App {


//
  val sparkSession = SparkSession .builder()
    .appName("SparkJOB")
    .master("local")
    .config("spark.driver.allowMultipleContexts", "true")
    .config("es.index.auto.create", "true")
    .config("spark.es.resource", "index/type")
    .getOrCreate


  val sparkContext = sparkSession.sparkContext

  // Design By Contract
  //require(sc.version.replace(".","").toInt >= 160, "Spark version should be 1.6+ or greater")

  /****************************  DATASET ********************************************************/
//  import sparkSession.implicits._
//
//  val dataset = sparkSession.createDataset(List("IN", "US", "HK"))
//  dataset.map(eachElement => eachElement.concat(" - COUNTRY_CODE")).foreach(each => println(each))

//  val csvDataframe = sparkSession.read.csv("")
//
//  val csvDataSet = sparkSession.read.csv("").as[String]

//  val csvDataSetText = sparkSession.read.text("hdfs://localhost:9000/covtype.info").as[String]
//  csvDataSetText.foreach(x => println(x))
  /****************************  DATASET ********************************************************/

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

//    val pairRDD = sparkContext.textFile("file:////Users/dharshekthvel/ac//insurance.csv")
//                              .map(x => (x.split(",")(0),x.split(",")(1)))
//                              .foreach(x => println(x._1 + " " + x._2))



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

      val rdd = sparkContext.parallelize(List(100,
                                              200,
                                              300,
                                              400,
                                              500))

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


  /***************** String methods ************************************************************/
  // String has methods inside

//  val aString = "CHE-GUERA"
//  println(aString.drop(4))


  /**************************  Enumeration in Scala *******************************************/
  //println(CountryCode.FRANCE)


  /*************** Collect Transformaation Scala ***************************************/
//  val partialFunction : PartialFunction[String, String] = {
//    case eachElement: String => eachElement.concat(" - CHOLA")
//
//  }
//
//
//  val list = List ("CHERA", "PANDYA", "PALLAVA")
//  list.collect(partialFunction).foreach(eachElement => println(eachElement));

  /*************** Collect Transformaation Scala ***************************************/



  /*********************************  Elastic Search Connector ************************/
//  import org.elasticsearch.spark._
//  import org.elasticsearch.spark.streaming._

//
//  val sparkSession = SparkSession .builder()
//                                  .appName("SparkJOB")
//                                  .master("local")
//                                  .config("spark.driver.allowMultipleContexts", "true")
//                                  .config("es.index.auto.create", "true")
//                                  .config("spark.es.resource", "index/type")
//                                  .getOrCreate
//
//    val sparkConfig = new SparkConf().setMaster("local[*]")
//                                     .setAppName("StreamingJOB")
//                                     .set("spark.driver.allowMultipleContexts", "true");
//
//    val streamingContext = new StreamingContext(sparkConfig, Seconds(1))
//

//  val sparkContext = sparkSession.sparkContext




    //Save the data
//   EsSpark.saveToEs(rdd, "spark99/svmIndex")
//    rdd.saveToEs("spark99/svmIndex")

//
//  //Read the data
//  //val rddRead = sparkContext.esRDD("spark99/svmIndex")
//  rdd.foreach(x => println(x))
//
//
//
//  // Writing Stream Data to Elastic Search Index
//  val microbatches = mutable.Queue(rdd)
//  val dstream = streamingContext.queueStream(microbatches)
//
//  streamingContext.queueStream(microbatches).saveToEs("spark99/meshIndex")
//  // (or)
//  EsSparkStreaming.saveToEs(dstream, "spark99/meshIndex")


  /*********************************  Elastic Search Connector ************************/


  /*********************************  Kafka Streaming - New API ************************/

//  val sparkConf = new SparkConf()
//  sparkConf.setAppName("StreamingJOB").setMaster("local[*]")
//
//  val sparkContext1 = new SparkContext(sparkConf)
//
//  val streamingContext = new StreamingContext(sparkContext1, Seconds(2))
//
//  import org.apache.kafka.clients.consumer.ConsumerRecord
//  import org.apache.kafka.common.serialization.StringDeserializer
//  import org.apache.spark.streaming.kafka010._
//  import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
//  import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
//
//  val kafkaParams = Map[String, Object](
//    "bootstrap.servers" -> "localhost:9092",
//    "key.deserializer" -> classOf[StringDeserializer],
//    "value.deserializer" -> classOf[StringDeserializer],
//    "group.id" -> "GROUP-ID",
//    "auto.offset.reset" -> "latest",
//    "enable.auto.commit" -> (false: java.lang.Boolean)
//  )
//
//  val topics = Array("DMAC")
//
//  val stream = KafkaUtils.createDirectStream[String, String](
//    streamingContext,
//    PreferConsistent,
//    Subscribe[String, String](topics, kafkaParams)
//  )
//
//  stream.map(record => (record.key, record.value)).print()
//
//  streamingContext.start()
//  streamingContext.awaitTermination()
  /*********************************  Kafka Streaming - New API ************************/



  /*********************************  Basic Socket Streaming - New API ************************/

//  val sparkConf = new SparkConf()
//
//  sparkConf.setAppName("StreamingJOB")
//           .setMaster("local[*]")
//
//  val sparkContext1 = new SparkContext(sparkConf)
//
//  val streamingContext = new StreamingContext(sparkContext1, Seconds(1))
//
//  val stream = streamingContext.socketTextStream("localhost", 1234)
//
//  stream.map(x => x).print()
//
//  streamingContext.start()
//  streamingContext.awaitTermination()
  /*********************************  Basic Socket Streaming - New API ************************/




    /*********************************  KMeans Clustering  ************************/
//    val sparkConfig = new SparkConf
//        sparkConfig.setMaster("local[*]")
//        sparkConfig.setAppName("HDFS");
//
//    val sparkContext = new SparkContext(sparkConfig)
//
//
//    val parsedData = List(12,33,33)
//    // Cluster the data into two classes using KMeans
//    val numClusters = 2
//    val numIterations = 20
//    // val clusters = KMeans.train()
//
//    val data = sparkContext.parallelize(parsedData)
//
//
//    data.cache()
//
//    val dataVector = data.map(x=> Vectors.dense(x))
//
//  val kMeansModel = KMeans.train(dataVector,numClusters,numIterations)
//  val predictions = kMeansModel.predict(Vectors.dense(1))
//
//  println(predictions)

  /*********************************    KMeans Clustering  ************************/






//  val sparkConfig = new SparkConf
//sparkConfig.setMaster("local[*]")
//  sparkConfig.setAppName("HDFS");
//
//  val sparkContext = new SparkContext(sparkConfig)
//
//
//  val textFileRDD = sparkContext.textFile("hdfs://localhost:9000/insurance.csv", 100)
//
//  textFileRDD.getNumPartitions
//
//
//  val insuranceRDD = textFileRDD.map(x => InsuranceDTO(x.split(",")(0),x.split(",")(2)))
//
//  insuranceRDD.union(insuranceRDD).union(insuranceRDD).union(insuranceRDD).union(insuranceRDD).union(insuranceRDD)
//    .filter(eachRDD => eachRDD.country.startsWith("A"))
//    .cartesian(insuranceRDD)
//    .take(100)
//






    val rangeOfNumbers = 1 to 100


    val numberRDD = sparkContext.parallelize(rangeOfNumbers)


    val multipliedRDD =   numberRDD.map(x => x*2)


    val unionRDD = numberRDD.union(multipliedRDD)


    val keyValueUnionRDD = unionRDD.map(x=> (x,x))



    println(keyValueUnionRDD.toDebugString)



}

case class InsuranceDTO(code: String, country: String)

case class SVMSupportVector(name: String, feature: String, id: Int)

object CountryCode extends Enumeration {

  type CountryCode = Value

  val INDIA  = Value("IN")
  val FRANCE = Value("FR")
  val RUSSIA = Value("RU")

}

class SparkPrinter {

  def printEachLine(eachLine : String) : String = {
    println(eachLine)
    eachLine
  }

}


case class NLPNamedEntityDTO(name_1: String,
                             name_2: String,
name_3: String,name_4: String,name_5: String,name_6: String,name_7: String,
                             name_8: String,name_9: String,name_10: String,name_11: String,
                             name_12: String,name_13: String,name_14: String,name_15: String,
                             name_16: String,name_17: String,name_18: String,name_19: String,
                             name_20: String,name_21: String,name_22: String)