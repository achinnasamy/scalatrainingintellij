package com.dmac.dv

/**
  * Created by dharshekthvel on 10/27/16.

  Variants are the generics of scala. Initially it may sound confusing but the below
  example is a simple example which explains the three types of variants in one shot.

  Variants are of three types in Scala.
  1. Covariant        +T
  2. Contravariant    -T
  3. Invariant         T

  Covariant - Only subtypes of the defined class
  Contravariant - Only supertypes of the defined class
  Invariant - Only the particular class

  By default scala classes are invariants in nature.

  */
object VariantsOfClass {


  // Only subtypes of WildAnimals are fine
  def covariant(zoo : Zoo1[WildAnimals]) = {

  }

  // Only supertypes of WildAnimals are fine
  def contravariant(zoo : Zoo2[WildAnimals]) = {

  }

  // Only WildAnimals are fine. By default are scala classes are Invariant in nature
  def invariant(zoo : Zoo3[WildAnimals]) = {

  }

  def main(args : Array[String]) = {

    covariant(new Zoo1[WildAnimals])
    covariant(new Zoo1[Lion])
    //covariant(new Zoo1[Animals]) // Compilation fails


    contravariant(new Zoo2[WildAnimals])
    //contravariant(new Zoo2[Lion])  // Compilation fails
    contravariant(new Zoo2[Animals])


    invariant(new Zoo3[WildAnimals])
    //invariant(new Zoo3[Lion]) // Compilation fails
    //invariant(new Zoo3[Animals]) // Compilation fails


  }
}


// Covariant - Only subtypes of WildAnimals are fine
class Zoo1[+T] {

}

// Contravariant - Only supertypes of WildAnimals are fine
class Zoo2[-T] {

}

// Invariant - Only WildAnimals are fine. By default are scala classes are Invariant in nature
class Zoo3[T] {

}

class Animals

class WildAnimals extends Animals

class Lion extends WildAnimals




