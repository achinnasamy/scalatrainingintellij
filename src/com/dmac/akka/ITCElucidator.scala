
import org.apache.spark.sql.SparkSession

object ITCElucidator {


  def main(args : Array[String]) = {




    val sparkSession = SparkSession.builder()
                          .appName("SparkJOB").master("local").getOrCreate()


    val bc = sparkSession.sparkContext.broadcast(RegressionDTO("data"))


    import sparkSession.implicits._

    val ds = sparkSession.createDataset(List("E1", "E2"))
    val ds1 = sparkSession.read.text("/a.txt").as[String]

    val df = sparkSession.sqlContext.read.option("header", "false")
                                    .csv("/sales.csv")
    df.show(100)

    df.createTempView("SALES")
    df.createOrReplaceTempView("")

    df.createGlobalTempView("")

    df rdd

    df.describe("COlumn").show(100)


    df.select("Column", "C2").show(100)
    df.select(df.col("Column"), df.col("C2").gt("_SCHEMA"))
    df.select(df.col("Column"), df.col("C2").gt("_SCHEMA"))

    import org.apache.spark.sql.functions._
//    val toDouble = udf[Double, String](_.toDouble)
//    df.withColumn("COLUMN", toDouble(df.col("COLUMN")))

    df.printSchema()

    sparkSession.catalog.cacheTable("")
    sparkSession.catalog.refreshTable("")
    sparkSession.catalog.clearCache()

    sparkSession.catalog.dropGlobalTempView("")


    val a = sparkSession.sql("SELECT _C0 FROM SALES")

    df.write.option("compression", "snappy").partitionBy("").parquet("")
    df.write.orc("")

    df.printSchema()
  }


  case class RegressionDTO(name : String)
}