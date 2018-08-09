

Plesae follow the following steps to start the services:
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
npm install react-scripts -g
npm start

http://localhost:3000