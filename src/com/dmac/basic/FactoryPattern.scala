package com.dmac.basic

object FactoryPattern extends App {
  
  val input = "QuickSearch"
  
  val search = input match {
    
    case "QuickSearch" => new QuickSearch
    case "TimSearch" => new TimSearch
    
    case _ => new TimSearch
  }
  
  search.doSearchAlgorithm
}


trait Search {
  def input {
    //Get the Input
  }
  def doSearchAlgorithm
}

class QuickSearch extends Search {
  def doSearchAlgorithm {
    println("Quick Search Algorithm")
  }
}

class TimSearch extends Search {
  def doSearchAlgorithm {
    println("Tim Search Algorithm")
  }
}

