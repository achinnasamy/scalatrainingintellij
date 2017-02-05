package com.dmac.leb

/**
  * Created by Aravindh Chinnasamy on 2/4/17.
  */
trait ScalaInterview {

  // 1 - Given an order, produce a list of product names.
  def productNamesFromOrder(order: Order): List[String]

  // 2 - Given a user, produce a list of products from all of their orders.
  def productsFromUser(user: User): List[Product]

  // 3 - Given an order, calculate the total price.
  def orderTotal(order: Order): Double

  // 4 - Given a list of products and a category name, produce a list of products in that category.
  // Make sure the solution handles a possibly missing category on a product.
  def productsInCategory(products: List[Product], category: String): List[Product]

  // 5 - Given list of products, produce a map of category to a list of products in that category.
  // Make sure the solution handles a possibly missing category on a product.
  def productsByCategory(products: List[Product]): Map[String, List[Product]]
}

