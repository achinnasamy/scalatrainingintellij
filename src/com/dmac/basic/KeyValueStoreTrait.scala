package com.dmac.basic

trait KeyValueStoreTrait {
  
  def put(value : Any) : Boolean
  
  def get() : Any
  
  def dataStoreName(): String = {
      return "REDIS"
  }
  
}