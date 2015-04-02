# GeohashPigUDF
* Build the UDF via: 
```
mvn clean package 
```
* The packaged jar can then be imported into a pig script via the REGISTER command and used like other UDFs.
* Example of using the UDF: 
  
```
REGISTER /root/pig/udfs/geohash-1.0-SNAPSHOT.jar;

A = LOAD '/user/root/data/crimes.csv' USING PigStorage('\t');
B = FILTER A BY NOT($19 == '') AND NOT($20 == '');
C = FOREACH B GENERATE *,geohash.Encode($19, $20, 12);
```
