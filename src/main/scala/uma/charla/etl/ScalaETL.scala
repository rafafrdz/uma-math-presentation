package uma.charla.etl

object ScalaETL {

  def extract(): List[String] =
    List("1,foo", "2,baar", "3,baz", "Scala is better than Java (no chance)")

  def transform(data: List[String]): List[SData] = {
    data.flatMap { line =>
      line.split(",") match {
        case Array(id, value) if id.forall(_.isDigit) => Some(SData(id.toInt, value))
        case Array(value)                             => Some(SData(187, value))
        case _                                        => None
      }

    }
  }

  def load(data: List[SData]): Unit =
    data.foreach(println)

  // Now we're gonna use the main

  def main(args: Array[String]): Unit = {
    val rawData       = extract()
    val transformData = transform(rawData)
    load(transformData)
  }

}
