//package com.dmac.spark
//
//import java.util
//
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.util.AccumulatorV2
//
///**
//  * Created by dharshekthvel on 1/26/17.
//  */
//object AccumulatorPattern extends App {
//
//  val sparkSession = SparkSession.builder()
//    .appName("SparkJOB").master("local[*]").config("spark.local.dir","/Users/dharshekthvel/ac")
//    .getOrCreate()
//
//  val myOwnAccumulator = new MyOwnAccumulator
//
//  sparkSession.sparkContext.register(myOwnAccumulator)
//
//
//
//
//
//  sparkSession.sparkContext.textFile("").map(z => {
//
//    myOwnAccumulator.add(MeshFile("",0))
//  })
//
//  myOwnAccumulator.value
//
//}
//
//class MyOwnAccumulator extends AccumulatorV2[MeshFile, MeshFile] {
//
//
//  private var _meshFile = new MeshFile("", 0)
//
//  override def value: MeshFile = _meshFile
//
//  override def add(v: MeshFile): Unit = {
//    _meshFile = v
//  }
//
//  override def reset(): Unit = {
//    _meshFile = new MeshFile("", 0)
//  }
//
//  override def isZero: Boolean = _meshFile.id.equals(0) && _meshFile.name.equals("")
//
//  override def merge(other: AccumulatorV2[MeshFile, MeshFile]): Unit = {
//    case o: MyOwnAccumulator =>
//
//      _meshFile.name = o._meshFile.name
//      _meshFile.id = o._meshFile.id
//
//    case _ =>
//      throw new UnsupportedOperationException(
//        s"Cannot merge ${this.getClass.getName} with ${other.getClass.getName}")
//
//
//  }
//
//  override def copy(): AccumulatorV2[MeshFile, MeshFile] = {
//
//    val myownAccumulator = new MyOwnAccumulator
//    myownAccumulator._meshFile = this._meshFile
//
//    myownAccumulator
//  }
//}
//
//
//case class MeshFile(var name : String, var id : Integer)
//
