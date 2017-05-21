package com.dmac.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by dharshekthvel on 18/4/17.
 */
public class SparkBasic {

    public static void main(String args[]) {
        SparkConf sparkConfig = new SparkConf()
                //.set("spark.local.dir", "/Users/apple")
                .setAppName("ReadCSVFile")
                .setMaster("local[8]");


        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConfig);

        // 5 is the number of partitions
        JavaRDD<String> rdd = javaSparkContext.textFile("hdfs://localhost:9000/a.txt");


        //rdd.foreach(x => System.out.println(x));
    }
}
