package com.dmac.kafka

import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.common.TopicPartition

import scala.collection.JavaConverters._
/**
  * Created by dharshekthvel on 31/5/17.
  */
object ScalaKafkaConsumer {

  def main(args : Array[String]) = {

    val props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("group.id", "VEL-GROUP1");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("session.timeout.ms", "30000");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


    val consumer = new KafkaConsumer[String, String](props);
    consumer.subscribe(util.Collections.singletonList("VEL"));

    val topicPartition = new TopicPartition("CHE", 0)

    //val tList = List(topicPartition)

    //consumer.assign(tList.asJavaCollection)


    //consumer.poll(10)
    //consumer.seekToBeginning(tList.asJavaCollection)
    //consumer.seek(topicPartition, 2)

    while(true) {
      val records=consumer.poll(0)

      //consumer.seek(topicPartition, 0)
      consumer.commitSync()
      consumer.commitAsync()

      for (record<-records.asScala){
        println(record)
      }
    }

  }
}
