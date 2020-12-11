import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;

import org.apache.spark.sql.*;

import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.api.java.function.MapFunction;

public class Main {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config("spark.some.config.option", "some-value")
                .config("spark.master", "spark://orion12:21071")
                .getOrCreate();


        // The schema is encoded in a string
        String schemaString = "itemID userID reviewDate";

        // Create an RDD
        JavaRDD<String> peopleRDD = spark.sparkContext()
                .textFile("hdfs://orion11:21001/final01/part-r-00000", 1)
                .toJavaRDD();

// Generate the schema based on the string of schema
        List<StructField> fields = new ArrayList<>();
        for (String fieldName : schemaString.split(" ")) {
            StructField field = DataTypes.createStructField(fieldName, DataTypes.StringType, true);
            fields.add(field);
        }
        StructType schema = DataTypes.createStructType(fields);

// Convert records of the RDD (people) to Rows
        JavaRDD<Row> rowRDD = peopleRDD.map((Function<String, Row>) record -> {
            String[] attributes = record.split(",");
            return RowFactory.create(attributes[0], attributes[1].trim());
        });

// Apply the schema to the RDD
        Dataset<Row> peopleDataFrame = spark.createDataFrame(rowRDD, schema);

// Creates a temporary view using the DataFrame
        peopleDataFrame.createOrReplaceTempView("people");

// SQL can be run over a temporary view created using DataFrames
        Dataset<Row> results = spark.sql("SELECT itemID FROM people WHERE itemID = 1450808581");

// The results of SQL queries are DataFrames and support all the normal RDD operations
// The columns of a row in the result can be accessed by field index or by field name
        Dataset<String> namesDS = results.map(
                (MapFunction<Row, String>) row -> "Name: " + row.getString(0),
                Encoders.STRING());
        namesDS.show();








//
//        // Create an RDD of Person objects from a text file
//        JavaRDD<ReviewInfo> peopleRDD = spark.read()
//                .textFile("hdfs://orion11:21001/final01/part-r-00000")
//                .javaRDD()
//                .map(line -> {
//                    String[] parts = line.split("\t");
//                    ReviewInfo reviewInfo = new ReviewInfo();
//                    reviewInfo.setItemID(parts[0]);
//                    reviewInfo.setUserID(parts[1]);
//                    reviewInfo.setReviewDate(parts[3]);
//                    return reviewInfo;
//                });
//
//// Apply a schema to an RDD of JavaBeans to get a DataFrame
//        Dataset<Row> peopleDF = spark.createDataFrame(peopleRDD, ReviewInfo.class);
//// Register the DataFrame as a temporary view
//        peopleDF.createOrReplaceTempView("reviewInfos");
//
//// SQL statements can be run by using the sql methods provided by spark
//        Dataset<Row> teenagersDF = spark.sql("SELECT itemID FROM reviewInfos WHERE itemID = 1450808581");
//
//// The columns of a row in the result can be accessed by field index
//        Encoder<String> stringEncoder = Encoders.STRING();
//        Dataset<String> teenagerNamesByIndexDF = teenagersDF.map(
//                (MapFunction<Row, String>) row -> "Name: " + row.getString(0),
//                stringEncoder);
//        teenagerNamesByIndexDF.show();
//// +------------+
//// |       value|
//// +------------+
//// |Name: Justin|
//// +------------+
//
//// or by field name
//        Dataset<String> teenagerNamesByFieldDF = teenagersDF.map(
//                (MapFunction<Row, String>) row -> "Name: " + row.<String>getAs("name"),
//                stringEncoder);
//        teenagerNamesByFieldDF.show();
// +------------+
// |       value|
// +------------+
// |Name: Justin|
// +------------+
    }
}
