# NikeCodingExercise
A RESTful microservice that implements a card shuffling algorithms


# Prerequisites for Applcation:
- Java version: 1.8.0_101
- Apache Maven 3.3.9 
- apache-tomcat-7.0.77
- Make sure apache-tomcat-7.0.77 server is up and running on your system

# How To Test Application?
- Download the cardshuffling folder and save on your local drive
- open terminal and navigate to location */cardshuffling
- use commands like:
  - mvn compile
  - mvn package
- Inside */cardshuffling/target/ folder you will find cardshuffling.war WAR folder
- Deploy this WAR into your apache-tomcat-7.0.77 server
- Restart apache-tomcat-7.0.77
# OR
- You can directly paste the WAR file given on github https://github.com/akedari/NikeCodingExercise/blob/master/cardshuffling.war
# OR
- You can import the cardshuffling package into Eclipse and right click on cardshuffling package and choose option 
  Run As -> Run on Server


After you depoy your WAR on tomcat server, perform below steps:
- Open any client like Postman and hit the URL http://localhost:8080/cardshuffling/webapi/decks
- Here you can perform the operations like GET, POST, PUT, DELETE on Deck of cards.

# Operation
1. GET: (parameter need to pass in URL)
  - GET a list of the current decks persisted in the service.
  - example - http://localhost:8080/cardshuffling/webapi/decks
  - GET a named deck in its current sorted/shuffled order.
  - Paramter need to pass in URL after decks/
  - example - http://localhost:8080/cardshuffling/webapi/decks/abhi
  
2. PUT (parameter need to pass in Message Body)
  - PUT an idempotent request for the creation of a new named deck.
  - New deck get created in some initial sorted order.
  - You need to pass name of deck in Message body in Text(text/plain) format
  - example - http://localhost:8080/cardshuffling/webapi/decks/
  - Body [format Text(text/plain)]-> abhijeet 
  
3. POST (parameter need to pass in Message Body)
  - POST a request to shuffle an existing named deck.
  - Depending upon Shuffling Strategy mentioned in config.properties. Shuffling will be performed
  - Example - http://localhost:8080/cardshuffling/webapi/decks/
  - Body [format Text(text/plain)]-> abhijeet 
  
4. DELETE (parameter need to pass in URL)
  - DELETE a named deck.
  - Example - http://localhost:8080/cardshuffling/webapi/decks/
  - Body [format Text(text/plain)]-> abhijeet 
  
  
  
 
