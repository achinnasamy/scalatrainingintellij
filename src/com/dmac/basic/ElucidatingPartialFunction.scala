package com.dmac.basic

import sun.plugin.cache.FileVersion

/**
  * Created by dharshekthvel on 8/6/17.
  */
object ElucidatingPartialFunction {


  def main(args : Array[String]) = {

    val one = new One

    val two = new PartialFunction[Int, String] {
      override def isDefinedAt(x: Int): Boolean = if (x==2) true else false

      override def apply(v1: Int): String = "TWO"
    }


    val three: PartialFunction[Int, String] = { case 3 => "THREE" }


    val four: PartialFunction[Int, String] = { case 4 => "FOUR" }


    val mypartialfunction = one orElse two orElse three orElse four



    println(one(1))

    println(two(2))

    println(three(3))

    println(mypartialfunction isDefinedAt 3)

    if (mypartialfunction isDefinedAt 3)
      println("Final Output : " + mypartialfunction(3))

    if (mypartialfunction isDefinedAt 3)
      println(mypartialfunction(3))
  }
}


class One extends PartialFunction[Int, String] {
  override def isDefinedAt(x: Int): Boolean = if (x==1) true else false

  override def apply(v1: Int): String = "ONE"
}
