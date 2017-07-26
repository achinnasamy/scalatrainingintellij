package com.dmac.advanced

import org.apache.spark.{Partition, TaskContext}
import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.rdd.RDD

/**
  * Created by dharshekthvel on 30/6/17.
  */
object CustomRDD {

}

case class BB(handTemplate: String)



class BiometricBeanRDD(biometricBeanRDD : RDD[BB])
extends RDD[BB](biometricBeanRDD) {


  override def compute(split: Partition, context: TaskContext): Iterator[BB] = {
    firstParent[BB].iterator(split, context).map(eachRecord => {
      BB("")
    })
  }

  override protected def getPartitions: Array[Partition] = {
    firstParent[BB].partitions
  }
}



