package com.dmac.spark

/**
  * Created by dharshekthvel on 2/15/17.
  */
object Cloudant extends App {



  val countryCodes = List("IN", "UR", "US", "BH")

  countryCodes.map(eachElement => {
    val cc = new CountryCodeBL();
    cc.doComplexStuff(eachElement)
  }).foreach(x => println(x))



  }

class CountryCodeBL {


  def doComplexStuff(name : String) : String = {
    name.concat("_DETAIL")
  }
}

case class CountryCodeDetail(name : String)