# UMA Charla

## Project Structure

This project is structured into two main parts:

- Scala Application
- Java Application

Both explain how to do a simple ETL. However, the Scala application add a *How to* use Spark to perform the ETL, while the Java application uses plain Java code.

### Scala Application

The Scala application is located in the `src/main/scala/uma/charla/etl/` directory. It contains the following classes:

- `SData`: A case class that represents a row in a dataset.
- `ScalaETL`: This is the main class of the application. It demonstrates how to do an ETL with plain Scala code.

### Spark Application (with Scala)

The Spark application is located in the `src/main/scala/uma/charla/spark/` directory. It contains the following classes:

- `Dataframe`: This is the main class of the application. It demonstrates various operations on Spark DataFrames and Datasets, such as creating a DataFrame from a schema, adding a new column, creating Datasets from Scala native classes, and interacting with a PostgreSQL database through JDBC.

### Java Application

The Java application is located in the `src/main/java/uma/charla/etl/` directory. It contains the following classes:

- `JData`: A class that represents a row in a dataset.
- `JavaETL`: This is the main class of the application. It demonstrates how to do an ETL with plain Java code.

### Docker Setup

The Docker setup is located in the `docker/` directory. It contains a `docker-compose.yml` file which is used to set up a PostgreSQL database for the Scala application to interact with.

## How to Deploy

To deploy this project, you need to have Docker and Docker Compose installed on your machine. Once you have these installed, you can deploy the project by following these steps:

1. Navigate to the `docker/` directory in your terminal.
2. Run the command `docker-compose up`. This will start the PostgreSQL database.
3. In a separate terminal window, navigate to the root directory of the project.
4. Run your Scala application. Make sure that the PostgreSQL database is running before you start the application.

Please note that you may need to adjust the JDBC connection properties in the `Dataframe` class to match your Docker setup.

Or execute the following command:

```bash
docker-compose -f docker/docker-compose.yml up -d
```

## Languages and Frameworks

This project uses the following languages and frameworks:

- Java
- Scala
- Apache Spark
- sbt (Scala Build Tool)