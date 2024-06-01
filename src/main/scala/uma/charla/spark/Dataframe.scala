package uma.charla.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

import java.util.Properties

object Dataframe extends App {

  val sp = SparkSession
    .builder()
    .appName("Dataframe")
    .config("spark.master","local")
    .getOrCreate()

  import sp.implicits._

  /*
  CREATE A DATAFRAME

  FROM A SCHEMA WE'RE GONNA CREATE A DATAFRAME WITH THIS STRUCTURE
   (title: string, points: int, factor:int)
   */

  val schema : StructType = StructType(Array(
    StructField("title",StringType),
    StructField("points",IntegerType),
    StructField("factor",IntegerType)
  ))

  //Once we create the schema we can generate the dataframe through createDataframe() method
  //First we create the data with array of Row's type
  val data : Array[Row] = Array(
    Row("The GoodFather",10,5),
    Row("Battle Royale",4,3),
    Row("Taxi Driver",10,3),
    Row("Blade Runner",4,3),
  )

  //Transform that data into RDD
  val rdd: RDD[Row] = sp.sparkContext.parallelize(data)


  val df: DataFrame = sp.createDataFrame(rdd,schema)

  //show's method recollect the data from cluster and show it on console
  df.show()

  /*
  How can we add a new column that makes points * factor?

  We can use withColumn method follow with the expression we 're gonna to calculate
   */

  val dfmultiplica: DataFrame = df.
    withColumn("multiply",$"points"* $"factor")

  dfmultiplica.show()

  /*
  We can create Datasets through Scala native classes
   */

  case class Pelicula (title : String, points : Int, factor : Int)

  val seqPelicula: Seq[Pelicula] = Seq(
    Pelicula("The GoodFather",10,5),
    Pelicula("Battle Royale",4,3),
    Pelicula("Taxi Driver",10,3)

  )


  val dfPelicula: Dataset[Pelicula] = seqPelicula.toDS()
  //This kind of types let us to controll on compilation time the data type we're processing

  dfPelicula.printSchema()

  /*
  We can create Dataset with several Scala types. Imagine that we wanna create a new Option[Int] column type
   */

  case class Pelicula2 (title : String, points : Int, factor : Option[Int])


  val seqPelicula2 : Seq[Pelicula2] = Seq(
    Pelicula2("The GoodFather",10,Some(5)),
    Pelicula2("Battle Royale",4,Some(3)),
    Pelicula2("Taxi Driver",10,Some(3)),
    Pelicula2("Unknown",0,None)
  )

  val dfPelicula2: Dataset[Pelicula2] = seqPelicula2.toDS()

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /*
  We are created our own PostgresSQL BBDD through a Docker (docker-compose.yml we need to enter on folder> cmd> docker-compose up)
  we can create differents tables on the BBDD through SQL scripts here is some examples

  SCRIPT SQL
  create table filmranking(
		title varchar(50),
		points int,
		factor int

	insert into filmranking values('clockwork orange',4,2);


);

   */

  // Inicializate the jdbc connector
  val jdbConnectionProperties = new Properties()

  jdbConnectionProperties.put("user","postgres")
  jdbConnectionProperties.put("password","prueba")

  val jdbcDF = sp.read.jdbc("jdbc:postgresql://localhost:5432/postgres","public.peliculaprueba",jdbConnectionProperties)


  //With theses connector we are able to obtain information from "external" services
  jdbcDF.show()


  //Same way we can write from our programm to the external services

  dfmultiplica
    .write
    .jdbc("jdbc:postgresql://localhost:5432/postgres", "public.new_table", jdbConnectionProperties)














}
