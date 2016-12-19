package com.dmac.basic

object FilterTransformation extends App {
  
          val countries = List("Brazil",
                       "Russia", 
                       "Bahamas",
                       "Bangladesh",
                       "Cook Islands", 
                       "UK",
                       "Norway", 
                       "Sweden",
                       "Germany",
                       "France")
                       

          val filtered =  countries. filter { x => x.startsWith("B") }.foreach { x => println(x) }
          
          val filtered1 =  countries. filter { (x:String) => x.startsWith("B") }.foreach { x => println(x) }
          
          val filtered2 =  countries. filter ( _.startsWith("B") ).foreach { x => println(x) }
          
          
          val svmList = 
          List(
                  SupportVectorMachineBean("AverageCallHandlingTime", 12f, 1f),
                  SupportVectorMachineBean("SupervisorMetric", 15f, 7f),
                  SupportVectorMachineBean("GYRScore", 2f, 1f),
                  SupportVectorMachineBean("CallMetricRatio", 9f, 4f))

          
          svmList.filter { svmBean => svmBean.lowerSupportVector > 2f }
                 .foreach { vector => println(vector.name) } 
                 
                 
                 val ll =    svmList.filter (_.lowerSupportVector > 2f)
                                    .map { x => SVMNameBean(x.name)}
                                    .toList 
}



case class SupportVectorMachineBean (var name : String, 
                                     var highSupportVector : Float, 
                                     var lowerSupportVector : Float)
                                     
case class SVMNameBean(var name : String)