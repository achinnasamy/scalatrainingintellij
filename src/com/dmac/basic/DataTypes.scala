package com.dmac.basic

object DataTypes {
  
  def main(args : Array[String]) : Unit = {
    
    /**
     			Byte
     			Short
     			Int
     			Long
     			Float
     			Double
     			Char
     			String
     			Boolean
     			Unit			-	No value (Equivalent to void in java)
     			Null
     			Nothing		- The subtype of every type. Includes no values
     			Any
     			AnyRef
     
     			All are objects. There are no primitives as of Java.
     */
    
    
    var declarationOfString = "I am a String Declared"
    
    var anotherVersionOfDeclarationOfString : String = "Another String Declared"
    
    println(declarationOfString); //Semicolon is not mandatory
    
    println(anotherVersionOfDeclarationOfString)


		// Multiple Assignments
		val (name: String, age: Int, salary : Float) = ("Chola", 100, 102f)


		println(name)


    
  }

	@inline def reckonerData(ref : Int) = {

	}
}