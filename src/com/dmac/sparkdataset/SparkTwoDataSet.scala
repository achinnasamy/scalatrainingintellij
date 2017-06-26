package com.dmac.sparkdataset

import org.apache.spark.sql.SparkSession

/**
  * Created by dharshekthvel on 16/6/17.
  */
object SparkTwoDataSet {


  def main(args : Array[String]) = {



    val sparkSession = SparkSession.builder()
      .appName("SparkJOB").master("local[*]")
      .getOrCreate()

    import sparkSession.implicits._

    val dataset = sparkSession.createDataset(List(
      "INVESTMENT_BANK_TIMELINE_1",
      "INVESTMENT_BANK_TIMELINE_02",
      "INVESTMENT_BANK_TIMELINE_003"))

    val lengthDataset = dataset.map(each => each.length)

    lengthDataset.foreach(x => println(x))
  }
}
