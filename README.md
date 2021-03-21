# Os-tracking-system-project
 
###Technologies used

Python
Java, Spring, Hibernate, REST
PostgreSQL server
TimeLeaf 

###Short description

Application is written for system administrators, it contains 3 parts. The first part - python client that the system administrator can send to users that operate on the computers that admin should control and manage. Users run the python script, the script automatically collects data about the system(CPU usage, disk usage, open ports, etc..) and sends this data to the java server. The server receive and store obtained data in the database. The system administrator can view obtained data using the administration tools. For more details see the user manuals folder.  

###Implementation

For implementation description please see the documentation folder

###Functionality

For deeply explained functionality please see user manuals inside the manuals folder

The main functionality of the client program is to collect and send to the server:
  1 Number of CPUs
  2 Used power of CPU in percents at the moment
  3 All disks names
  4 Used and free storage on each disk
  5 Open ports of the machine
  
The main functionality of the server program:
  1 receive information from the client
  2 store information in the database

The main functionality of the administration tool
  1 Display the data in form of the dashboard
