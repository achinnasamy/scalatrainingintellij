package com.dmac.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

/**
  * Created by dharshekthvel on 31/5/17.
  */
object ScalaKafkaProducer {


  def main(args : Array[String]) = {


    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("client.id", "ScalaProducer")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("linger.ms", "1")
    props.put("batch.size","123456")
    props.put("compression.codec","1")
    //props.put("partitioner.class", "com.dmac.kafka.KafkaUserCustomPartitioner");

    val producer = new KafkaProducer[String, String](props)

    val data = new ProducerRecord[String, String]("TIGER", "A", "MAY-17-Revolution-1")


    for (i <- 1 to 100) {
      producer.send(data, oncallback)
    }
    val producerMetrics = producer.metrics()

    //print(producerMetrics)
    // Kafka producer produces a flush method to ensure all previously sent messages have been actually completed.
    //producer.flush()



    producer.close()

  }


  val oncallback = new Callback {
    override def onCompletion(recordMetadata: RecordMetadata, e: Exception) = {
//      //println(recordMetadata.offset())
//        println(recordMetadata.checksum())
//      println(recordMetadata.topic())
//      println(recordMetadata.partition())
    }
  }
}
