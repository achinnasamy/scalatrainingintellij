package com.dmac.spark.partitioning

import org.apache.spark.{Partitioner, SparkConf, SparkContext}

/**
  * Created by dharshekthvel on 18/5/17.
  */
object YearPartitionerMain extends App {

  val sparkConfig = new SparkConf
  sparkConfig.setAppName("IBMJOB")
  sparkConfig.setMaster("local[*]")

  val sparkContext = new SparkContext(sparkConfig)
  val list = List(1923, 1800, 2012, 1834, 1987, 2014);


  val listRDD = sparkContext.parallelize(list)


  val pairRDD = listRDD.map(x => (x,0))

  val partitionedData = pairRDD.partitionBy(new YearPartitioner)

//  partitionedData.mapPartitions(dataIterator =>
//                                        dataIterator.map(dataInfo => println(dataInfo)))
//                 .collect()


  val mapPartitionIndexRDD = partitionedData.mapPartitionsWithIndex((partitionIndex, dataIterator) =>
                                                dataIterator.map(dataInfo => "Partition is - " + partitionIndex + " - Data = " + dataInfo))

  mapPartitionIndexRDD.saveAsTextFile("/home/dharshekthvel/dele199")

  print("Partitioner " + partitionedData.partitioner)


}



class YearPartitioner extends Partitioner {

  override def numPartitions: Int = {
    15
  }

  override def getPartition(key: Any): Int = {
    val k = key.asInstanceOf[Int]
    if (k > 2000)
      10
    else if (k > 1900 && k < 2000)
      11
    else
      12
  }
}