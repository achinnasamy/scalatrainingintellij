package com.dmac.basic

/**
  * Created by dharshekthvel on 26/6/17.
  */
object ListReckoner {


  def main(args: Array[String]) = {

    val nlpList = List("TOKENIZATION", "LEMMATIZATION", "STEMMING", "POS")

    // For a mutable list either use a  ListBuffer or a ArrayBuffer
    // As the name indicates ArrayBuffer array as the datastructure and
    // ListBuffer uses LinkedList data structure internally

    val supervisedLearning = scala.collection.mutable.ListBuffer("Regression")
    supervisedLearning += "SVM"
    supervisedLearning += "DecisionTrees"


    val unsupervisedLearning = scala.collection.mutable.ArrayBuffer.empty[String]
    unsupervisedLearning += "Clustering"

    supervisedLearning foreach println
    unsupervisedLearning foreach println


  }
}
