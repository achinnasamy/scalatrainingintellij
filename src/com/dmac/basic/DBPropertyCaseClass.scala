package com.dmac.basic

object DBPropertyCaseClass {
  
  def main(args:Array[String]) {
    var dbProp = DBProperties("slz_core",3306,"jdbc:mysql:slz-zone3","slz_core")
   
    println(dbProp.connectionString)
    dbProp.connectionString = "jdbc:oracle:slz-zone2"   
    
    println(dbProp.connectionString)
  }
}


case class DBProperties(var dataBaseName: String, 
                        var portNo : Int, 
                        var connectionString :String,
                        var schemaName: String)