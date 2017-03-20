//package com.dmac.basic
//
//import javax.swing.{ JFrame => MyAppFrame }
//
//
//object Basics {
//
//  /**
//   * A Simple Scala Method
//   */
//  def scalaMethod(empName:String, empDepartment : String) : Int = {
//    return 1001
//  }
//
//  def main(args : Array[String]) {
//
//    ranges()
//
//    /** Scala has a built in type-inference mechanism. The compiler
//     		deduces the type from the initialization expression of the variable.
//     **/
//    val twelve = 3 + 9
//    val assignMe = "Assign Me"
//
//    val assignMeNil = Nil
//    val assignMeNull = null
//
//
//
//    println(twelve.isValidInt)
//    println(assignMe)
//
//    println(assignMeNil)
//    println(assignMeNull)
//    /****************************************************/
//
//
//    /****************************************************/
//    // Re-naming a class while at import is allowed
//    // import javax.swing.{ JFrame => MyAppFrame }
//    val myFrame = new MyAppFrame
//    //myFrame.show(true)
//
//    myFrame show true
//    /****************************************************/
//
//    // Import inside a code block is permitted.
//    // But validity of the import is allowed with in the code block
//    import javax.swing.JPanel
//    val panel = new JPanel
//
//    myFrame.add(panel)
//    //myFrame add panel
//
//
//    stringManipulations
//  }
//
//
//  def allDataTypes() {
//
//    val simpleNumeric         = 1982
//    val simpleNumericaAlias   = 1982 : Int
//
//    val simpleFloat           = 32f
//    val simpleFloatAlias      = 32f : Float
//
//    val simpleDouble          = 33d
//    val simpleDoubleAlias     = 33d : Double
//
//    val simpleLong            = 48787L
//    val simpleLongAlias       = 48787L : Long
//
//    var addition = simpleNumeric + simpleNumeric
//    addition = simpleNumeric + 1
//
//    addition += 1
//
//
//    var titanicNumber = BigInt(1234567890)
//    var titanicDecimal = BigDecimal(63746.64636)
//  }
//
//  def ranges() {
//
//    var range100 = 1 to 100
//
//    var range50 = 1 to 100 by 2
//
//
//    println(range100)
//
//    for (i <- range100)
//      println(i)
//
//
//  }
//
//  def stringManipulations() {
//
//    val CONSTANT_STRING = "STRING"
//
//    CONSTANT_STRING.drop(2).foreach { x => println(x) }
//
//
//
//    val multiLineString = "First Line " +
//	                                    "Second Line"
//
//    val multiLineStringAlias = """ This is first Line
//                                           This is second line
//                                               This is third line """
//
//
//    println(multiLineString)
//    println(multiLineStringAlias)
//
//    println(multiLineString(4))
//  }
//}