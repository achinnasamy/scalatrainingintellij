package com.dmac.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 9/6/17.
  */
object SparkSQLZeppelin {

  def main(args : Array[String]) = {


    val sparkSession = SparkSession.builder()
      .appName("SparkZeppelinJOB").master("local[*]")
      .getOrCreate()

    import sparkSession.implicits._

    val dataset = sparkSession.createDataset(List("INVESTMENT_BANK_TIMELINE_001",
      "INVESTMENT_BANK_TIMELINE_002",   "INVESTMENT_BANK_TIMELINE_003"))

    dataset.createGlobalTempView("INVESTMENT_TABLE")

    sparkSession.sql("SELECT * FROM INVESTMENT_TABLE").show(100)
  }
}
