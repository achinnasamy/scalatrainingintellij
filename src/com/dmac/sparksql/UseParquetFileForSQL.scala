package com.dmac.sparksql

import org.apache.spark.sql.SparkSession

/**
  * Created by dharshekthvel on 20/6/17.
  */
object UseParquetFileForSQL {

    def main(args : Array[String]) = {


      val sparkSession = SparkSession.builder().appName("ParqueJOB")
                            .master("local[*]").getOrCreate()


      val salesCSV = sparkSession.sqlContext.read.option("header","true")
                    .csv("/home/dharshekthvel/Desktop/ac/code/scalatrainingintellij/data/salessimple.csv")

      salesCSV.rdd.saveAsTextFile("alluxio://localhost:19998/sales")

//        salesCSV.write
//            //.option("compression","snappy")
//            .option("compression","gzip")
//            .partitionBy("CookingGear","CampingEquipment")
//            .parquet("/home/dharshekthvel/Desktop/ac/code/scalatrainingintellij/data/sales_partition_gzip.parquet")


//      salesCSV.write.partitionBy("Productline")
//                  .parquet("/home/dharshekthvel/Desktop/ac/code/scalatrainingintellij/data/saless_partitions.parquet")
//


      //salesCSV.write.orc("/home/dharshekthvel/Desktop/ac/code/scalatrainingintellij/data/saless_partitions.orc")


      // Bucket by is available only on Hive and not on any other format.
//      salesCSV.write.bucketBy(2, "Productline")
//                    .saveAsTable("/home/dharshekthvel/Desktop/ac/code/scalatrainingintellij/data/SS")



      //.parquet("/home/dharshekthvel/Desktop/ac/code/scalatrainingintellij/data/sales.parquet")


    }
  }
