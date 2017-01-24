package com.dmac.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by dharshekthvel on 1/23/17.
  */
object SparkSQL extends App {

  val sparkSession = SparkSession.builder()
    .appName("SparkJOB").master("local[*]").config("spark.local.dir","/Users/dharshekthvel/ac")
    .getOrCreate()

  // Spark Context

//  val sparkContext = sparkSession.sparkContext
//
//  val file = sparkContext.textFile("/Users/dharshekthvel/ac/auth.csv")
//
//  file.foreach(eachLine => println(eachLine))
  //sparkContext.stop()



  //val jsonDataFrame = sparkSession.read.json("examples/src/main/resources/people.json")

  val csvDataFrame = sparkSession.read.csv("/Users/dharshekthvel/ac/training/sparktraining/data/undata1.csv")

  //csvDataFrame.show(10)

  //csvDataFrame.select("_c0").show(10)



//  csvDataFrame.createTempView("DATATABLE")
//  csvDataFrame.createOrReplaceTempView("MYOWNTABLE")
    csvDataFrame.createGlobalTempView("STRUCTUREDTABLE")


  csvDataFrame.write.csv("")

//  sparkSession.sql("SELECT _c0,_c1 FROM DATATABLE").show(100)

  sparkSession.sql("SELECT _c0,_c1 FROM global_temp.STRUCTUREDTABLE").show(100)

sparkSession.catalog.refreshTable("")
  sparkSession.catalog.cacheTable("")
  sparkSession.catalog.clearCache()
  sparkSession.catalog.dropTempView("")
sparkSession.catalog.dropGlobalTempView("")
  sparkSession.catalog.createExternalTable("","")
}
