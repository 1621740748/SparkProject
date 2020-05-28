package org.sunny

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.log4j.{Level, Logger}
import org.apache.spark.storage.StorageLevel

import scala.util.Sorting
object sparkApp{
  print("hellp")

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org.apache").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("mengapp")
      .setMaster("local[2]")
    val sc = new SparkContext(conf)

    def my(x:Int):Boolean = x match {
      case x if x>3 => true
      case x if x<=3 => false
    }
    val rdd3 = sc.parallelize(List(1,2,3,4,5,7,8,9,11,13))
    val res = rdd3.groupBy(my)
    res.foreach(println)
    //取出RDD中某一个元素
    val num = res.count()
    val rddList = res.take(num.toInt) //将RDD转为Array

    //keyBy：为数据集中每个个体数据增加一个key，形成键值对
    val rdd4 = sc.parallelize(List(1,2,3,4,5,7,8,9,11,13,15))
    val res2 = rdd4.keyBy(_*2)

    val res3 = res2.sortBy(x=>x._1,false) //或者直接使用
    res3.foreach(println)
    println("--------------")
    val res4 = res2.sortByKey()
    res4.foreach(println)



  }
}