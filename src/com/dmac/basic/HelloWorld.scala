package com.dmac.basic

/**
  * Created by dharshekthvel
  */
object HelloWorld {

  def main(args: Array[String])  {
    println("The world is good")
  }



  import com.dmac.basic.ImplicitClassesFeature._
  val out = "NLP_".letMoonBeAddedToString()

  println(out)
}
