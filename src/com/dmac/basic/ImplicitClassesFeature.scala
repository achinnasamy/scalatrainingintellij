package com.dmac.basic

/**
  * Created by dharshekthvel on 20/6/17.
  */
object ImplicitClassesFeature {

//  Implicit classes are usually put inside a object. So that import can be easy.
//  Implicit classes can have only one constructor argument

  implicit class AddFunctionalityToString(val input: String) {

    def letMoonBeAddedToString() : String = input.concat("MOON")
  }


//      Usage of implicit class
  //
//  import com.dmac.basic.ImplicitClassesFeature._
//  val out = "NLP_".letMoonBeAddedToString()
//  println(out)

}
