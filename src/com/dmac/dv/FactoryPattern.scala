package com.dmac.dv

/**
  * Created by dharshekthvel on 10/27/16.
  */
object FactoryPattern {

  def main(args: Array[String]) = {

  }
}



trait BigDataFileFactory {

  type jSONFile <: JSONFile
  type parquetFile <: ParquetFile
  type avroFile <: AvroFile


  def createJSONFile(fileName:String)
  def createParquetFile(fileName:String)
  def createAvroFile(fileName:String)

  abstract class JSONFile(fileName : String)
  abstract class ParquetFile(fileName : String)
  abstract class AvroFile(fileName : String)

}

object HortonworksFileFactory extends BigDataFileFactory {

  def createJSONFile(fileName:String) = new HortonworksJSONFile("")
  def createParquetFile(fileName:String) = new HortonworksParquetFile("")
  def createAvroFile(fileName:String) = new HortonworksAvroFile("")

  protected class HortonworksJSONFile(fileName : String) extends JSONFile(fileName)
  protected class HortonworksParquetFile(fileName : String) extends ParquetFile(fileName)
  protected class HortonworksAvroFile(fileName : String) extends AvroFile(fileName)
}