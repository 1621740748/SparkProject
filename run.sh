#!/bin/bash
scp target/SparkProject-1.0-SNAPSHOT.jar home:/data/temp/SparkProject-1.0-SNAPSHOT.jar
ssh home sudo docker cp  /data/temp/SparkProject-1.0-SNAPSHOT.jar  v2_master_1:/
ssh home "sudo docker exec -i v2_master_1 spark-submit --class org.sunny.wordCount /SparkProject-1.0-SNAPSHOT.jar"


