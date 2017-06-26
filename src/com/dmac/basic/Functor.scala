package com.dmac.basic



trait Functor[F[_]] {

  self => def map[A, B](fa: F[A])(f: A => B): F[B]


}