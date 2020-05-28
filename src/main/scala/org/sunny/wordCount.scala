package org.sunny
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.log4j.{Level, Logger}
import org.apache.spark.storage.StorageLevel

import scala.util.Sorting
object wordCount{
  print("hellp")

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org.apache").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("mengapp")
      .setMaster("local[2]")
    val sc = new SparkContext(conf)
    val words = sc.textFile("hdfs://localhost:8020/words")
    val wordsFlatMap = words.flatMap(_.split("\\W+"))
    val wordsMap = wordsFlatMap.map( w => (w,1))
    val wordCount = wordsMap.reduceByKey( (a,b) => (a+b))
    val wordCountSorted = wordCount.sortByKey(true)
    wordCountSorted.collect.foreach(println)

  }
}