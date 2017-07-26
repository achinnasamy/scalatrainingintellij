//package com.dmac.kafka
//
//import java.util.Properties
//
//import org.apache.kafka.streams.KafkaStreams
//import org.apache.kafka.streams._
//import org.apache.kafka.streams.kstream.Reducer
//
//import org.apache.kafka.common.serialization._
//import org.apache.kafka.streams._
//import org.apache.kafka.streams.kstream.{KStream, KStreamBuilder}
//import KeyValueImplicits._
//import FunctionImplicits._
//
//import org.apache.kafka.streams.kstream.{KStream, KStreamBuilder, KeyValueMapper}
//import scala.language.implicitConversions
//
///**
//  * Created by dharshekthvel on 4/6/17.
//  */
//object KafkaStreamBuilder {
//
//
//  def main(args : Array[String]) = {
//
//
//
//
//    val streamsConfig = {
//      val props = new Properties()
//      props.put("bootstrap.servers", "localhost:9092")
//      props
//    }
//
//    val kStreamBuilder = new KStreamBuilder
//
//    val textLines: KStream[Array[Byte],String] = kStreamBuilder.stream("STREAM_TOPIC")
//
//    //val uppercasedWithMapValues: KStream[Array[Byte], String] =
//
//    textLines.to("UPPER_CASE_TOPIC")
//
//
//    val stream = new KafkaStreams(kStreamBuilder, streamsConfig)
//    stream.start()
//    //stream.close()
//
//
//  }
//}
//
