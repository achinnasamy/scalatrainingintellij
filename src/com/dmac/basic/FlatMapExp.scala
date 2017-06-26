package com.dmac.basic

/**
  * Created by dharshekthvel on 17/4/17.
  */
object FlatMapExp extends App {


  val list = List("Chinnasamy", "BigData")

  val a = list.flatMap (
    _.toUpperCase
  ).foreach(x => println(x))



  // All the below definitions are legal
  list.map(x => x.toUpperCase).foreach(each => println(each))
  list.map({x => x.toUpperCase}).foreach(each => println(each))
  list.map { x => x.toUpperCase } .foreach(each => println(each))
  list.map(_.toUpperCase).foreach(println(_))
}
