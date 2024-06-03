package uma.charla

import cats.{~>, Monad}

package object category {

  /** Environment contexts */

  trait Prod[T]

  trait Local[T]

  trait Test[T]

  /** Natural transformation between environment contexts */
  implicit val nt1: Prod ~> Local = λ[Prod ~> Local](_ => ???)

  implicit val nt2: Local ~> Test = λ[Local ~> Test](_ => ???)

  /** Monad instances for environment contexts */

  implicit val prodMonad: Monad[Prod] = new Monad[Prod] {
    override def pure[A](x: A): Prod[A] = ???

    override def flatMap[A, B](fa: Prod[A])(f: A => Prod[B]): Prod[B] = ???

    override def tailRecM[A, B](a: A)(f: A => Prod[Either[A, B]]): Prod[B] = ???
  }

  implicit val localMonad: Monad[Local] = new Monad[Local] {
    override def pure[A](x: A): Local[A] = ???

    override def flatMap[A, B](fa: Local[A])(f: A => Local[B]): Local[B] = ???

    override def tailRecM[A, B](a: A)(f: A => Local[Either[A, B]]): Local[B] = ???
  }

  implicit val testMonad: Monad[Test] = new Monad[Test] {
    override def pure[A](x: A): Test[A] = ???

    override def flatMap[A, B](fa: Test[A])(f: A => Test[B]): Test[B] = ???

    override def tailRecM[A, B](a: A)(f: A => Test[Either[A, B]]): Test[B] = ???
  }
}
