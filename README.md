# linkedlistapi

This Application is written in Java using Spring Boot framework.
----------------------------------------------------------------

Artifact Name :- 

linked-list-api-1.0.jar
---------------------------------------

How to run :- 

Give the following command to run on default port : java -jar linked-list-api-1.0.jar
Give the following command to run on specific port :java -Dserver.port=<PORT> -jar linked-list-api-1.0.jar
-------------------------------------------------------------------------------------------------------------

Assumptions made :-

1.Push functionality : The application allows to add more than one objects (to the specified list) with same 
					   Request Body upon which it will assign a unique "id" to every such object.

2.Remove functionality : In case more than one objects found in the given list that match the Request Body, 
					     the application will remove every such object from the list.
					   
3.An "id" assigned to an object of a list is always incremental irrespective of any operation done on the list.
  For instance, if a list has 3 objects with id = 1, id = 2 and id = 3 and then the objects with id = 2 and id = 3 
  are REMOVED/POPPED, any object PUSHED to the list after this will be assigned id = 4 and so on.
-------------------------------------------------------------------------------------------------------------
