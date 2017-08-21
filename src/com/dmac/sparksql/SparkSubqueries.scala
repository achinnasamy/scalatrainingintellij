//package com.dmac.sparksql
//
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql.functions._
//
///**
//  * Created by dharshekthvel on 16/6/17.
//  */
//object SparkSubqueries {
//
//
  def main(args : Array[String]) = {


    val sparkSession = SparkSession.builder().appName("SQLJob").master("local[*]").getOrCreate()


    /**********************************************************************************************/
    /* Basic Query - Election Data  */
    /**********************************************************************************************/
    import sparkSession.implicits._

    val electionCSV = sparkSession.sqlContext.read.option("header", "true")
      .csv("/home/dharshekthvel/Desktop/ac/code/scalatrainingintellij/data/electiondata.csv")

    electionCSV.createOrReplaceTempView("ELECTION")
    //electionCSV.show(10)

    val electionDF = electionCSV.toDF()

    val toInt    = udf[Int, String]( _.toInt)

    sparkSession.sql("SELECT * FROM ELECTION").show(999)

    val electionCSVModifiedSchema = electionCSV.withColumn("CQ", toInt(electionDF.col("CQ")))
    electionCSVModifiedSchema.groupBy("REP_PARTY", "STATE").sum("CQ").show(100)

    //sparkSession.sql("SELECT REP_NAME, CQ FROM ELECTION").show(999)


    val salesCSV = sparkSession.sqlContext.read.option("header","true")
                               .csv("/home/dharshekthvel/Desktop/ac/code/scalatrainingintellij/data/sales.csv")


//
//    /**********************************************************************************************/
//    /* Common Operations   */
//    /**********************************************************************************************/
//
//    val toDouble    = udf[Double, String]( _.toDouble)
//
//    salesCSV.show(100)
//
//    salesCSV.printSchema()
//
//
//    val salesDF = salesCSV.toDF()
//
//    val salesModifiedSchema = salesCSV.withColumn("Revenue", toDouble(salesDF.col("Revenue")))
//
//    salesModifiedSchema.printSchema()
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    /********************************************************************************/
//    /* Statistical Data Exploration */
//    /********************************************************************************/
//    //electionCSV.describe("CQ").show()
//
//    //electionCSV.describe("REP_NAME").show()
//
//    // histogram is a method in
//    //val hist = electionCSV.select("CQ").map(x => Integer.parseInt(x.getString(0))).rdd.histogram(5)
//
//    //hist._2.foreach(x => println(x))
//
//
//    /********************************************************************************/
//
//    //electionCSV.cube()
//  }
//}
