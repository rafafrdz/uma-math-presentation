package charlauma.etlscala

object ScalaETL {

  def extract(): List[String] = {
    List("1,foo", "2,baar", "3,baz", "Scala is better than Java (no chance)")
  }

  def transform(data: List[String]): List[Data] = {
    data.flatMap { line =>
      line.split(",") match {
        case Array(id, value) if id.forall(_.isDigit) => Some(Data(id.toInt, value))
        case Array(value) => Some(Data(187, value))
        case _ => None
      }

    }
  }

  def load(data: List[Data]): Unit = {
    data.foreach(println)
  }

  // Now we're gonna use the main

  def main(args: Array[String]): Unit = {
    val rawData = extract()
    val transformData = transform(rawData)
    load(transformData)
  }

}
