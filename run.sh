#!/bin/bash
scp target/SparkProject-1.0-SNAPSHOT.jar home:/data/temp/SparkProject-1.0-SNAPSHOT.jar
echo "-------------"
ssh home sudo docker cp  /data/temp/SparkProject-1.0-SNAPSHOT.jar  v2_master_1:/
echo "*****************"
ssh home "sudo docker exec -i v2_master_1 spark-submit --class org.sunny.sparkApp /SparkProject-1.0-SNAPSHOT.jar"
echo "---------------"


