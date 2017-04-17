package com.dmac.basic

/**
  * Implicit is a compile time feature
  */
object ImplicitFeature {
  
  implicit val floatValue = 167f

  implicit val defaultHoursOfWork = 8

  def printAge(implicit name : String) {
    println(s"printing age of $name")
  }
  
  implicit def getName(age : Int) : String = {
    println("obtaining name")
    "CHINNASAMY"
  }
  
  
  def getMeRoundedNumberOfFloat(implicit anyFloatValue : Float) {
    println(anyFloatValue)  
  }


  def work(nameOfPerson: String) (implicit durationOfWork : Int) = {
    println("Name of the person and the hours he worked - " + nameOfPerson + " - " + durationOfWork)
  }
  /* Two implicit functions cannot be possible 
  implicit def getName(age: Int) : String = {
    ""
  } */
  
  def main(args: Array[String]) {
//    printAge(12)
    
//    getMeRoundedNumberOfFloat


    val money = 100;
    println("Printing the implicit" + 100.words)

    work("Che")
  }

  // Implicit classes as extension methods

  implicit class MoneyToWords(val n: Int) {
    def words() : String = {
      if (n == 100) "One Hundred"
      else if (n == 200) "Two Hundred"
      else "No Money"
    }
  }
  
}

