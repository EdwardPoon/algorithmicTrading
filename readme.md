
## **Introduction**

1. project dataproducer: 
It works as 3rd party source which publishes an stock price.
It's generating price with timestamp in every 10 seconds , Use RxJAVA as reactive programming framework :

2. dataconsumer :
It saves the data into mongodb when data got received 
another function is to calculate the stock price

3. eureka-service : 
It is an eureka service which for introducing eureka microservie functions

4. price-ui : 
a react js UI client which querys the average price of last x price


## **Run the services**
1. start  eureka-service
cd eureka-service
mvn clean install
mvn spring-boot:run

http://localhost:8761/

2. start dataconsumer
cd dataconsumer
mvn clean install
mvn spring-boot:run

service dataconsumer can be found in http://localhost:8761/

3. start dataproducer
cd dataproducer
mvn clean install
mvn spring-boot:run

service dataproducer can be found in http://localhost:8761/

4. start UI
cd price-ui  
npm install  
npm start  

http://localhost:3000