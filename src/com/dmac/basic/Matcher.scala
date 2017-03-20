//package com.dmac.basic
//
//import scala.io.StdIn
//
//object Matcher extends App {
//
//
//  print("Enter a month : ")
//  val input = StdIn.readInt // Read the Input from the console
//
//  val month = input match {
//    case 1 => "JAN"
//      case 2 => "FEB"
//        case 3 => "MAR"
//          case 4 => "APR"
//            case 5 => "MAY"
//              case 6 => "JUNE"
//                case 7 => "JULY"
//                  case 8 => "AUG"
//                    case 9 => "SEP"
//                      case 10 => "OCT"
//                        case 11 => "NOV"
//                          case 12 => "DEC"
//
//    case 0 | 13 => "Give an integer between 1 and 12"
//    case _ => "INVALID_MONTH"
//  }
//
//  println(month)
//}