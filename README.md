# nosql2018-worst_accidents
##Data
You can import data from https://opengovdata.ru/dataset/statgibddru
Data generated with parser: https://github.com/Shorstko/GibddStat
Import .json data files ony-by-one
You can create dump of DB (mongodump) and download it, then you can restore it using mongorestore

## Deploy
Run 'mvn clean install' in parent folder.
Required maven version greater than 3.1.0
Executable jar will generated in ./nosql-server/target directory

## Run
Already deployed file is Executable folder
Execute nosql-server-0.0.1-SNAPSHOT.jar using JRE with command:
java -jar nosql-server-0.0.1-SNAPSHOT.jar