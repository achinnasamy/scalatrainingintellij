package com.dmac.leb

import scala.collection.mutable.ListBuffer

/**
  * Created by Aravindh Chinnasamy on 2/4/17.
  */
class ScalaInterviewReckoner extends ScalaInterview {

  override def productNamesFromOrder(order: Order): List[String] = {
    var listOfnames = ListBuffer("")
    order.items.map(eachOrder => { listOfnames += eachOrder._1.name })
    listOfnames.toList
  }

  override def productsFromUser(user: User): List[Product] = {

    var listOfProducts = ListBuffer[Product]()

    user.orders.map(eachOrder => {
      eachOrder.items.foreach(
        eachSeq => listOfProducts += eachSeq._1)
    })

    listOfProducts.toList
  }

  override def orderTotal(order: Order): Double = {

    order.items
         .map(eachProduct => eachProduct._1.price * eachProduct._2)
         .reduce(_ + _)
  }


  override def productsInCategory(products: List[Product], category: String): List[Product] = {

    var listOfProducts = ListBuffer[Product]()

    products.map(eachProduct =>
      {
      if (eachProduct.categoryName.get.equals(category))
        listOfProducts += eachProduct
      }
    )

    listOfProducts.toList
  }

  override def productsByCategory(products: List[Product]): Map[String, List[Product]] = {
    products.groupBy(_.categoryName.getOrElse("None"))
  }

}

case class User(name: String, orders: Seq[Order])

case class Order(items: Seq[(Product, Int)])

case class Product(name: String, price: Double, categoryName: Option[String])


