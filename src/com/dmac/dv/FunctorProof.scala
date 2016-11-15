package com.dmac.dv

/**
  * Created by dharshekthvel on 10/28/16.
  */
object FunctorProof {

  val a = new Functor[MyDTO] {

    def simpleFunction[List](fa: MyDTO[List]): MyDTO[List] = new MyDTO

  }
}

trait Functor[F[_]] {


  def simpleFunction[A] (fa: F[A]) : F[A]

  //def complexFunction [Z,Y] (fa : F[Z]) (f: Z => Y) : F[Y]

}


class MyDTO[List] {


}

/*

Laws of Functors:


Laws of monads:



All monads are functors. But not all functors are monads.

 */