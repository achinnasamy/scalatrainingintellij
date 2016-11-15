package com.dmac.dv

import java.io.{BufferedReader, FileReader}

/**
  * Created by dharshekthvel on 10/23/16.
  */
object AnnotationsUsage {

  def main(args : Array[String]) : Unit = {

    //@volatile
    //val volatileKeyword = "A_VOLATILE_DECLARATION"

    @throws(classOf[MeshContractDataFlowException])
    val dataFlow = new DataFlow

    dataFlow.data("")

  }
}


class DataFlow {

  def data(message : String) = {
      throw MeshContractDataFlowException("Dataflow exception")
  }
}

case class MeshContractDataFlowException(message:String)  extends Exception(message)