package com.dmac.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

/**
  * Created by dharshekthvel on 31/5/17.
  */
object UsingCustomKafkaPartitioner {


  def main(args : Array[String]) = {


    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("client.id", "Mesh_Group")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("linger.ms", "1")
    props.put("batch.size","1")
    props.put("compression.codec","1")
    props.put("partitioner.class", "com.dmac.kafka.KafkaUserCustomPartitioner");

    val producer = new KafkaProducer[String, String](props)


    for (i <- 1 to 100) {
      val key = "Mesh_key".concat(i.toString)
      val value = "MESH_VALUE_".concat(i.toString)

      val data = new ProducerRecord[String, String]("MESH_TOPIC",
                                                    key,
                                                    value)

      producer.send(data)
    }

    producer.close()

  }

}
