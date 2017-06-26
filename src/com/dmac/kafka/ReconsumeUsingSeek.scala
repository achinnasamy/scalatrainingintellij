package com.dmac.kafka

import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

/**
  * Created by dharshekthvel on 31/5/17.
  */
object ReconsumeUsingSeek {

  def main(args : Array[String]) = {

    val props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("group.id", "SLZ-ZONE-GROUP");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "10");
    props.put("session.timeout.ms", "30000");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


    val consumer = new KafkaConsumer[String, String](props);
    consumer.subscribe(util.Collections.singletonList("TIGER"));

    consumer.poll(0)
    val topicPartition = consumer.assignment()

    val topicList = topicPartition.asScala.toList
    println("My topic list that I am subscribed - "+ topicList)
    consumer.seekToBeginning(topicList.asJavaCollection)

    while(true) {
      val records=consumer.poll(0)


      for (record<-records.asScala){
        println(record)
      }
    }

  }
}
