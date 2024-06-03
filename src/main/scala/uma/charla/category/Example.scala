package uma.charla.category

import cats.implicits._

object Example {

  case class User(name: String, age: Int, studies: String)

  case class Mathemathics(name: String, age: Int)

  /** Method to get users from a URL */
  def getUserFrom(url: String): List[Prod[User]] = ??? // undefined

  /** Method to match users with mathematics studies */
  def matchMathematic(user: User): Option[Mathemathics] =
    Option(user).collect { case User(name, age, "math") =>
      Mathemathics(name, age)
    }

  /** Production program run concurrently and with a lot of resources */
  def program(url: String): Prod[List[Mathemathics]] = {
    for {
      users <- getUserFrom(url).sequence
      maths <- users.flatMap(matchMathematic).pure[Prod]
    } yield maths
  }

  /** Local program run sequentially with no required resources */
  def local(url: String): Local[List[Mathemathics]] =
    nt1(program(url))

  /** Test program run sequentially with mocked resources and debugging every step */
  def test(url: String): Test[List[Mathemathics]] =
    (nt2 compose nt1)(program(url))
}
