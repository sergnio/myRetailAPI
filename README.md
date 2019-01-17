

# myRetailAPI
This is an end-to-end proof of concept for a products API, which aggregates product data from multiple sources and returns the data as JSON.

<h3>Technologies</h3>

Java 8 (compatible with 11) 

MongoDB 4.0.4 

Maven 4.0.0 

# Setup
Install [Java](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) if you haven't already. This project uses JDK8, but is compatible up to JDK11

Install [Maven](https://maven.apache.org/install.html), the build and dependency manager for this project.

Install [MongoDB](https://docs.mongodb.com/manual/administration/install-community/). After installed, start the mongo services.

Once mongo is up and running, start up the mongo shell with the command
```
mongo
```

Create a new ```productprice``` database by using this command, and enter some data into the newly created database.
```
use productprice

db.productprice.insertMany( [
{ _id: 13860428, value: 13.49, currency_code: "USD" },
{ _id: 13860429, value: 90.43, currency_code: "USD" },
{ _id: 13860425, value: 50, currency_code: "EUR" },
{ _id: 13860424, value: 1350, currency_code: "EUR" },
{ _id: 13860421, value: 12.59, currency_code: "CNY" },
{ _id: 13860419, value: 66.66, currency_code: "CNY" }
] );
```

To download the [Spring Boot](https://spring.io/projects/spring-boot) project, using [git](https://git-scm.com/downloads), clone the project and enter the directory.

```
$ git clone https://github.com/sergnio/myRetailAPI.git
$ cd myRetail
```

run a ```mvn install``` to grab all dependencies, compiles java files to class files and packages a jar file. Then run the jar file to start up a local tomcat API server. 
```
mvn install
java -jar target/products-api-0.0.1-SNAPSHOT.jar
```
After the build has completed, head over to [localhost:8080/v1/health](localhost:8080/v1/health), and you should simply see a message - "Server is running"

Congrats! 
# Live version
Instead of running locally, you may visit http://35.192.104.36:8080 for a live version of the demo. This is run on a Google Cloud Compute, Debian 9 instance.

Example queries:  
 [http://35.192.104.36:8080/v1/products/13860419](http://35.192.104.36:8080/v1/products/13860419)  
 [http://35.192.104.36:8080/v1/products/13860421](http://35.192.104.36:8080/v1/products/13860421)


# API 
These are valid endpoints included in this application.  

<h3>GET	../v1/products/{id}</h3>

**Description**: Get an existing product name from an external API and combine with the current pricing from our database.

Valid demo product ids: [13860428](http://35.192.104.36:8080/v1/products/13860428), [13860429](http://35.192.104.36:8080/v1/products/13860429), [13860425](http://35.192.104.36:8080/v1/products/13860425), [13860424](http://35.192.104.36:8080/v1/products/13860424), [13860421](http://35.192.104.36:8080/v1/products/13860421), [13860419](http://35.192.104.36:8080/v1/products/13860419)

Accepts: {id} path variable for a product id

Example:
```
{
    "id": 13860428,
    "name": The Big Lebowski (Blu-ray)
	"current_price": {
		"value": 13.49,
		"currency_code": "USD"
	}
}
```

***

<h3>PUT	../v1/products/{id}</h3>

**NOTE**: You will have to use an API testing tool, such as [Postman](https://www.getpostman.com/) to test the ```PUT``` 

**Description**:  If a product price with {id} exists, update an existing product price

Valid demo product ids: 13860428, 13860429, 13860425, 13860424, 13860421, 13860419


Accepts: {id} path variable for a product id
```
{
	"current_price": {
		"value": int,
		"currency_code": String
	}
}
```

Example:
```
{
	"current_price": {
		"value": 99330,
		"currency_code": "EUR"
	}
}
```
# Steps until production

For an MVP 1, this application would need at the minimum:
1) More end-to-end, integration, and unit tests
2) CI/CD builds
3) HTTPS

Certain things I would like to have completed/started  
1) All response messages in JSON format
2) Logging
3) Hosted in Docker container
4) Run on port 80, or 443 for HTTPS
