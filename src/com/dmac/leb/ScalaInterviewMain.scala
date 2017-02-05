package com.dmac.leb

/**
  * Created by dharshekthvel on 2/4/17.
  */
object ScalaInterviewMain extends App {


  val books = Product("BigDataInterviewFAQ", 30.0, Some("Books"))
  val shirts = Product("KadhiShirt", 100.0, Some("Clothing"))

  val products: Seq[(Product, Int)] = (books, 5) :: (shirts, 5) :: Nil

  val testOrder = Order(products)

  val testUser = User("tester", testOrder :: Nil)

  val scalaInterviewReckoner = new ScalaInterviewReckoner
  scalaInterviewReckoner.productNamesFromOrder(testOrder).foreach(x => println("Out " + x))
  scalaInterviewReckoner.productsFromUser(testUser).foreach(eachProduct => println("Product - " + eachProduct.price))
  scalaInterviewReckoner.productsInCategory(testOrder.items.map(_._1).toList, "Clothing")
                        .map(eachProduct => println("Product Print" + eachProduct.name))

}
