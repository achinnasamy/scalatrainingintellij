package com.dmac.basic

import scala.collection.mutable.Map

object Transformations extends App {
  
//  val zipTransformation = new ZipTransformation
//  zipTransformation.doZip
//  zipTransformation.doZipWithIndex
//  zipTransformation.partitionMe
//  zipTransformation.otherTransformations
//  zipTransformation parallelSequenceAndFlattening  
//    zipTransformation findTransformation 
//    zipTransformation reverseTransformation
    
  //val foldLeftObj = new Fold
 // foldLeftObj.elucidateFoldLeft
  //foldLeftObj elucidateReduceLeft
  
  //val reduce = new ReduceTransformation
  //reduce.elucidateReduceLeft 
  
  val mapTransformation = new MapTransformation
  mapTransformation.mapToBean()
}


class ZipTransformation {
  
  def doZip() {

    val country = List("Austria", "Bahamas", "Cook Islands")
    val code = List("AT","BS","CK")
    
        
    val zippedList = code.zip(country)
    zippedList.foreach(x => println(x))
  }
  
  def doZipWithIndex() {
    
    val country = List("Austria", "Bahamas", "Cook Islands")
    val zippedList = country.zipWithIndex
    zippedList.foreach(x => println(x))
    
  }
  
  def partitionMe() {
    
    val countries = List("Brazil",
                       "Austria", 
                       "Bahamas",
                       "Bangladesh",
                       "Cook Islands")
    val partitionedList = countries.partition { country => country.startsWith("B") }
    partitionedList._1.foreach { x => println(x) }
    partitionedList._2.foreach { x => println(x) }
    
    
  }
  
  def distinctElements() {
    
    val countries = List("Brazil",
                       "Austria", 
                       "Austria",
                       "Bahamas",
                       "Bahamas",
                       "Bangladesh",
                       "Cook Islands")
                       
    countries.distinct.foreach { x => println(x) }                   
                       
  }
  
  def otherTransformations() {
    
        val countries = List("Brazil",
                       "Austria", 
                       "Bahamas",
                       "Bangladesh",
                       "Cook Islands")
                       
        println("Tail Elements")
        countries.tail.foreach { x => println(x) }
   
        println("Head Element")
        println(countries.head)
   
        println("Take Elements")
        countries.take(3).foreach { x => println(x) }
        
        println("Drop Elements")
        countries.drop(3).foreach { x => println(x) }
        
        println("Count Elements")
        val countOfCountries = countries.count(element => element.startsWith("B"))
        println(countOfCountries)
        
        
  }
  
  def parallelSequenceAndFlattening() {
    
    val countries = List("Brazil",
                       "Russia", 
                       "Bahamas",
                       "Bangladesh",
                       "Cook Islands")
    
    val europeanCountries = List("UK",
                       "Norway", 
                       "Sweden",
                       "Germany",
                       "France")
                       
    countries.par.foreach { z => println(z) }
    
    val allCountries = List(countries, europeanCountries)
    
    val flattenedListOfCountries = allCountries.flatten
    flattenedListOfCountries.foreach { x => println(x) }
  }
  
  def findTransformation() {
    
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
       
       countries.find { x => x.startsWith("Ba") }.foreach { x => println(x) }
  }
  
  def reverseTransformation() {
    
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
       
       countries.reverse.foreach { x => println(x) }
  }
}

case class CountryNameBean(var name: String)

class MapTransformation {
  
  
  
  def mapTransformMe() {
    val countries = List("Brazil",
                       "Austria", 
                       "Bahamas",
                       "Bangladesh",
                       "Cook Islands")
                       
    countries.map { country => country.concat("_Country") }
             .foreach { x => println(x) }
  }
  
  
  case class CountryNameCodeBean(var name: String, var code: String)

  class CountryCodeBeanTransformation {
    
    def mapToCountryCode(countryNameBean : CountryNameBean) : CountryNameCodeBean = {
      

      if (countryNameBean.name == "Brazil") CountryNameCodeBean(countryNameBean.name, "BR")
      else if (countryNameBean.name == "Austria") CountryNameCodeBean(countryNameBean.name, "AU") 
      else CountryNameCodeBean(countryNameBean.name, "_NO_CODE_")
    }
  }

  /*********************************** Bounded Types ************************************/
  class MyOwnVariant[T]
  
  def referrentialArray[T <: AnyRef](xs: Array[T]): MyOwnVariant[T] = {
    return new MyOwnVariant[T]
  }
  
  
  
  class VariantParameterClass[T] 
  
  class ArrayListVariant[+T]
  
  // Input taking a bounded type which is a subtype of GrandParent
  def myOwnVariantInput[T <: GrandParent] (name : VariantParameterClass[T]) {
    
  }
  /*********************************** Bounded Types ************************************/
  
  def mapToBean() {
    
    val countries = List("Brazil",
                         "Austria", 
                         "Bahamas",
                         "Bangladesh",
                         "Cook Islands")
    
    val countryList = countries.map(country => CountryNameBean(country)).toList
    //countryList.foreach { x => println(x.name) }

    val countryNameCodeList = countryList.map(x => new CountryCodeBeanTransformation().mapToCountryCode(x)).toList
    countryNameCodeList.foreach { x => println(x.name) }
    
       
    // Function Name as A Variable is Used when you want to modify the original object
    val functionNameAsVariable = (countryNameBean:CountryNameBean) => 
                                                    { 
                                                          if (countryNameBean.name == "Brazil") countryNameBean.name = "BR"
                                                          else if (countryNameBean.name == "Austria") countryNameBean.name = "AU"
                                                          else countryNameBean.name = "_NO_CODE_"
                                                    }
    
                                                    
    println("\n\n\n Printing CountryNameCode ");
    countryList.map(functionNameAsVariable)
    
    countryList.foreach { x => println("Names changed to code - " + x.name) }
            
    }
}



class ReduceTransformation {
  
  def elucidateReduceLeft() {
    val stringList = List("A", "String", "in", "a", "list")
    val resultList = stringList.reduceLeft((x,y) => x.concat(" ").concat(y))
    println(resultList)
  }
}

class Fold {
  
  def elucidateReduceLeft() {
    
    val listOfNumbers = List(1,2,3,4,5)
    val result = listOfNumbers.reduceLeft(_ + _)
    println(result)
    
  }
  
  def elucidateFoldLeft() {
    val listOfNumbers = List(1,2,3,4,5)
    val result = listOfNumbers.foldLeft(0)(_ + _)
    println(result)
    
    
    val stringList = List("A", "String", "in", "a", "list")
    val resultList = stringList.foldLeft("The final String is : ")((x,y) => x.concat(" ").concat(y))
    println(resultList)
          
    val rangeOfNumbers = 1 to 1000
    val rangeResult = rangeOfNumbers.foldLeft(0)((x,y) => x+y)
    println(rangeResult)
  }
  
  def elucidateFoldRight() { 
    
    val stringList = List("A", "String", "in", "a", "list")
    val resultList = stringList.fold("The final String is : ")((x,y) => x.concat(" ").concat(y))
    println(resultList)
          
  }
  
  
}