package com.dmac.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

/**
  * Created by dharshekthvel on 31/5/17.
  */
object FirstScalaProducer {


  def main(args : Array[String]) = {


    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("client.id", "SLZ_CHAMBER")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("linger.ms", "1")
    props.put("batch.size","445")
    props.put("compression.codec","1")

    val producer = new KafkaProducer[String, String](props)

    val data = new ProducerRecord[String, String]("TIGER", "key_12", "Richard Feynman - thank you for your physics")

    producer.send(data)

    producer.flush()
    producer.close()

  }

}
