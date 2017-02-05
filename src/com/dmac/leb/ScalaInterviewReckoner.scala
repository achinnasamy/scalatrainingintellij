package com.dmac.leb

import scala.collection.mutable.ListBuffer

/**
  * Created by Aravindh Chinnasamy on 2/4/17.
  */
class ScalaInterviewReckoner extends ScalaInterview {


  // 1 - Given an order, produce a list of product names.
  override def productNamesFromOrder(order: Order): List[String] = {

    var listOfnames = ListBuffer("")
    order.items.map(eachOrder => { listOfnames += eachOrder._1.name })
    listOfnames.toList
  }

  // 2 - Given a user, produce a list of products from all of their orders.
  override def productsFromUser(user: User): List[Product] = {

    var listOfProducts = ListBuffer[Product]()


    user.orders.map(eachOrder => {
      eachOrder.items.foreach(
        eachSeq => listOfProducts += eachSeq._1)
    })

    listOfProducts.toList
  }
  // 3 - Given an order, calculate the total price.
  override def orderTotal(order: Order): Double = {

    order.items
         .map(eachProduct => eachProduct._1.price * eachProduct._2)
         .reduce(_ + _)
  }

  // 4 - Given a list of products and a category name, produce a list of products in that category.
  override def productsInCategory(products: List[Product], category: String): List[Product] = {

    var listOfProducts = ListBuffer[Product]()

    products.map(eachProduct =>
      {
      if (eachProduct.category.equals(category))
        listOfProducts += eachProduct
      }
    )

    listOfProducts.toList
  }

  // 5 - Given list of products, produce a map of category to a list of products in that category.
  override def productsByCategory(products: List[Product]): Map[String, List[Product]] = {


    products.groupBy(_.category)
  }

}

case class User(name: String, orders: Seq[Order])

case class Order(items: Seq[(Product, Int)])

case class Product(name: String, price: Double, category: String)


