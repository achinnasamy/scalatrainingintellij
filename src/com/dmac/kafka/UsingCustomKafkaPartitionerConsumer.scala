package com.dmac.kafka

import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.TopicPartition

/**
  * Created by dharshekthvel on 31/5/17.
  */
object UsingCustomKafkaPartitionerConsumer {


  def main(args : Array[String]) = {


    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("group.id", "Mesh_Group")

    // key.serializer and value.serializer is needed for Producer
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("linger.ms", "1")
    props.put("batch.size","1")
    props.put("compression.codec","1")

    // key.serializer and value.serializer is needed for Consumer
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    val consumer = new KafkaConsumer[String, String](props);
    consumer.subscribe(util.Collections.singletonList("MESH_TOPIC"));

    import scala.collection.JavaConverters._


    while(true) {
      val records=consumer.poll(1)


      for (record<-records.asScala){
        println(record)
      }
    }

  }

}
