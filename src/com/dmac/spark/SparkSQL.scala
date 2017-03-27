package com.dmac.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by dharshekthvel on 1/23/17.
  */
object SparkSQL extends App {

  val sparkSession = SparkSession.builder()
    .appName("SparkJOB").master("local[*]").config("spark.local.dir","/Users/dharshekthvel/ac")
    .getOrCreate()

  import sparkSession.implicits._
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



  csvDataFrame.createTempView("DATATABLE")
//  csvDataFrame.createOrReplaceTempView("MYOWNTABLE")
//    csvDataFrame.createGlobalTempView("STRUCTUREDTABLE")




  val dataTableDataframe = sparkSession.sql("SELECT _c0,_c1 FROM DATATABLE")


  sparkSession.sql("SELECT _c0,_c1 FROM DATATABLE").show(100)


  // Convert the dataframe to a dataset
  val countryMapper = sparkSession.sql("SELECT _c0,_c1 FROM DATATABLE").as[CountryMapper]


  //sparkSession.catalog.createExternalTable("SQL_TABLE","/Users/dharshekthvel/ac/storage")

//  val requiredDataFrame = sparkSession.sql("SELECT _c0,_c1 FROM global_temp.STRUCTUREDTABLE")
//  requiredDataFrame.write.csv("/Users/dharshekthvel/ac/out.csvv")
//  requiredDataFrame.write.parquet("/Users/dharshekthvel/ac/out.parquet")
//  requiredDataFrame.write.json("/Users/dharshekthvel/ac/out.json")
 // requiredDataFrame.write.saveAsTable("/Users/dharshekthvel/ac/storage")

  /* Spark Catalog */
//  sparkSession.catalog.refreshTable("TABLE_NAME")
//  sparkSession.catalog.cacheTable("TABLE_NAME")
//  sparkSession.catalog.clearCache()
//  sparkSession.catalog.dropTempView("TABLE_NAME")
//  sparkSession.catalog.dropGlobalTempView("TABLE_NAME")
//  sparkSession.catalog.createExternalTable("","")


}


case class CountryMapper(countryName : String, year : String)