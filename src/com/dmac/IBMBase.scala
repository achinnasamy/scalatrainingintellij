package com.dmac

import com.dmac.dv.DataStructure
//import org.apache.spark.scheduler.cluster.CoarseGrainedClusterMessages.SparkAppConfig
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
  * Created by dharshekthvel on 16/5/17.
  */
object IBMBase extends App {


//  val myDataRefNumber = 10034560
//  val myDataRefNumberAliter = { 10023456 }
//
//
//
//  val apache = new Apache with Logger
//  apache.getMyName()
//  apache.logMe("")
//apache.lazyNumber




  val config = new SparkConf()
  val sc = new SparkContext(config)

  val accumulator_counter = sc.longAccumulator("ACCUMU")

  //map(accumulator_counter.add(1L))


  accumulator_counter.value


}

class Apache extends Nifi {

  val proactiveNumber = { println("Initialized proactive"); 200 }

  lazy val lazyNumber = getMyName()

  override def getMyName(): String = {
    "APACHE"
  }
}

trait Nifi {

  def getMyName() : String = {
    "NIFI"
  }
}


trait Logger {

  def logMe(log : String) = {
    println(log)
  }
}




