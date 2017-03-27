package com.dmac.spark

import org.apache.hadoop.mapred._
import org.apache.spark.sql.SparkSession
import org.apache.hadoop.io.{IntWritable, LongWritable, MapWritable, Text}
import org.apache.spark.SparkFiles

/**
  * Created by dharshekthvel on 12/3/17.
  */
object CreationOfRDD extends App {

  val sparkSession = SparkSession.builder().appName("RDDCreatorJOB").master("local[*]").getOrCreate()


  val sparkContext = sparkSession.sparkContext
  val supportVectorList = List(SVMSupportVector("mesh", "12", 1),
    SVMSupportVector("maille", "15", 2),
    SVMSupportVector("referential", "33", 2))


  val rdd = sparkContext.makeRDD(supportVectorList)

  val rangeRDD = sparkContext.range(1,100,2,10)

//  rangeRDD.foreach(x => println(x))
//  rdd.foreach(x => println(x.name))

  val hadoopFileRDD = sparkContext.hadoopFile[LongWritable,Text,TextInputFormat]("file:////home/dharshekthvel/ac/docs/key-value.txt")
                        .map { case (x,y) => y.toString }


  hadoopFileRDD.foreach(x => println(x))



  import sparkSession.implicits._

  val covDataSet = sparkSession.read.text("hdfs://localhost:9000/covtype.info").as[String]
  covDataSet.foreach(x => println(x))
//



  //
//    .map{(x,y) => return y}
//    .foreach(x => println(x))


}
