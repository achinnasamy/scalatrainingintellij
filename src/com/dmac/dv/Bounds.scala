package com.dmac.dv

/**
  * Created by dharshekthvel on 10/22/16.
  */
object Bounds {

  def main(args : Array[String]) = {

//    // Upper Bound : An upper bound T <: A declares that T is a subtype of A.
//    val animalShouts = new AnimalShouts
//    animalShouts.whoIsShouting(new GermanShepherd())
//    animalShouts.whoIsShouting(new Dog())
//    //animalShouts.whoIsShouting(new Animal())

    val alphabets = new Alphabets
    alphabets.whatAlphabetIsIam(new A)
    alphabets.whatAlphabetIsIam(new B)
    alphabets.whatAlphabetIsIam(new C)
    alphabets.whatAlphabetIsIam(new D)
    alphabets.whatAlphabetIsIam(new E)


  }
}


class AnimalShouts {

  // Upper Bound
  def whoIsShouting[T <: Dog] (t:T): Unit = {
    println("Hey - " + t.getClass)
  }
}

class Alphabets[+T] {

  def whatAlphabetIsIam[T >: C] (t:T) : Unit = {
    println("Hey - " + t.getClass)
  }
}

class Animal
class Dog extends Animal
class GermanShepherd extends Dog

class A
class B extends A
class C extends B
class D extends C
class E extends D
