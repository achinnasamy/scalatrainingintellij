package com.dmac.basic

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 19/4/17.
  */
object FirstScalaProgram extends App {

  /*

		Failed to locate the winutils binary in the hadoop binary path
		java.io.IOException: Could not locate executable null\bin\winutils.exe in the Hadoop binaries.
			at org.apache.hadoop.util.Shell.getQualifiedBinPath(Shell.java:278)

		*/

  //  Put winutils.exe located in the config folder into D:\winutils\bin
  //  Add the line System.setProperty("hadoop.home.dir", "D:\\winutils\\")
  //  The above exception occurs only for the Windows Environment

  System.setProperty("hadoop.home.dir", "D:\\winutils\\");


  val sparkConfig = new SparkConf()

  sparkConfig.setAppName("SimpleSparkJOB")
  sparkConfig.setMaster("spark://zebra:7077")
//  sparkConfig.set("spark.driver.host", "localhost")

  val sparkContext = new SparkContext(sparkConfig)
  sparkContext.setCheckpointDir("")

  val textFileRDD = sparkContext.textFile("file:////home/dharshekthvel/ac/code/scalatrainingintellij/data/dataset.txt", 1)

  textFileRDD.checkpoint();

  textFileRDD.foreach(eachRDD => println(eachRDD))

  textFileRDD.persist(StorageLevel.OFF_HEAP)
  //textFileRDD.foreach(eachLine => println(eachLine))


  sparkContext.stop()

}


case class AuthDTO(ref : String, cityCode : String)