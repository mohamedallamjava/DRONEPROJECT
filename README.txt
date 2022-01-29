to run the application
open in the inteliJ or any IDE
make the project take the dependency
in java.com.drones.drones open appliaction file right click on it and run the file
P.S. no need to any configuration its run in-memory database
to add dron
http://localhost:9200/drones/adddrone
with paramters
{
 "seialnumber":"sometest",
    " model":"lightweght",
     "weight":200.00 ,
"state":"IDLE"
}


to add medication item
http://localhost:9200/medications/addmedication
in postman with formdata
parmter name file for image
paramter name md  string for json data
{
     "name":"aadd",
   "weight":200.00,
     "code":"sd334",
     "droneid":1
}

checking loaded medication items for a given drone
http://localhost:9200/medications/getMedcation
with parameter id for medication


checking available drones for loading
http://localhost:9200/drones/getavailabledrones
with paramter state for the drone


check drone battery level for a given drone
http://localhost:9200/drones/getdrones
with paramter id for drone



