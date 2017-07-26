package com.dmac.sparksql

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}

/**
  * Created by dharshekthvel on 27/6/17.
  */
object SpecifyingStrutureInSQL {

  def main(args : Array[String]) = {

    val sparkSession = SparkSession.builder().appName("ParqueJOB")
      .master("local[*]").getOrCreate()


    val data = sparkSession.sparkContext.parallelize(List(1,2,6,9,3,5,8))

    val mData = data.map(_*3)

    val fData = mData.collect()


    val salesCSV = sparkSession.sqlContext.read.option("header","true")
      .csv("/home/dharshekthvel/Desktop/ac/code/scalatrainingintellij/data/onecolumn.csv")



    val schema = StructType(Array(StructField("data_year", StringType, nullable = true)))

    val df = sparkSession.createDataFrame(salesCSV rdd, schema)

    df.show(100)



  }
}
