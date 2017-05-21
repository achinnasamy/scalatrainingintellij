import com.dmac.basic.CassandraFactory
import org.apache.spark.sql.SparkSession

/**
  * Created by dharshekthvel on 18/4/17.
  */
object HelloWorldIBM extends App {

  val cassandraIngestion = "CASSANDRA_INGESTION"
  println(s"Start the data ingestion... $cassandraIngestion ddd")

  val listOfNumbers = List(1,2,3,4,5)

  val session = SparkSession.builder()
              .appName("")
              .master("")
              .config("","")
              .getOrCreate()

  session.sqlContext.read.csv("")

  session.sql("")

}

case class DataCarrierDTO(name : String, length : Int)
