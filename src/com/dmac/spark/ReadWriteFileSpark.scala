package com.dmac.spark

import java.io.{File, PrintWriter}

import org.apache.spark.sql.SparkSession

/**
  * Created by dharshekthvel on 31/5/17.
  */
object ReadWriteFileSpark extends App {

  val sparkSession = SparkSession.builder()
                                 .appName("ReadWriteFile")
                                 .master("local[*]").getOrCreate()


  val textRDD = sparkSession.sparkContext.textFile("/home/dharshekthvel/ac/code/scalatrainingintellij/data/hadoop.csv")


  val mappedSecondColumnRDD = textRDD.map(x => x.split(",")(1));

  val emailsRDD = mappedSecondColumnRDD.map(x => {
    if (x.contains("@"))
      x
    else ""
  })

  val emails = emailsRDD.collect()

  var output = "";

  emails.foreach(x => output = output.concat(x + ","))

  print(output + "YES")
  val writer = new PrintWriter(new File("test.txt" ))
  writer.write(output)
  writer.flush()
  writer.close()

}
