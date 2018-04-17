
/**
  * Created by dharshekthvel on 4/16/18.
  */
object CaseObjectPattern {

  type AuthResult = Either[BiometricData, IrisData]

  def fetchDataResult(input : Int) : AuthResult = {

    if (input == 0)
      Left(BiometricData("hand-biometric"))
    else
      Right(IrisData("iris"))

  }

  def main(args: Array[String]) = {



    val output = fetchDataResult(0)

    output match {
      case Left(out) => println(out.biometric)
      case Right(out) => println(out.iris)
    }




  }


}


case class BiometricData(biometric : String)

case class IrisData(iris: String)
