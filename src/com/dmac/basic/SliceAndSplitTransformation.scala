package com.dmac.basic

/**
  * Created by dharshekthvel on 20/6/17.
  */
object SliceAndSplitTransformation extends App {


  val countries = List("Brazil",
    "Russia",
    "Bahamas",
    "Bangladesh",
    "Cook Islands")


  countries.slice(1,3).foreach(x => println(x))

  println("---------------------------------------")
  countries.splitAt(2)._1.foreach(x => println(x))
}
