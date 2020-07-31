# Mini-Shopify
The goal of this project is to provide a simple implementation of shopify using Spring MVC.

## HEROKU SITE
https://spring-mini-shop.herokuapp.com/

## Prerequisites

* JDK 8, although later version should work as well
* IntelliJ, the code is stored as an intelliJ project
* Violet for UML diagrams


## Running the tests

Use maven test to run the unit tests

```
mvn -B test
```

Continuous Integration is provided via Travis-CI

## Start the app manually

Import this project into Intellij, open MiniShopifyApplication.java, click run. 

After running the app you can go to http://localhost:8080/ to see the app running.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## UML

UML diagrams are in the folder named UML

## Milestone 1:

* Setup the project
* Created basic classes
* Added basic functionallity to write and read data

## Milestone 2:

* Added a simple login feature
* Improved the look and feel
* Added missing tests
* Added more functionality:
   -users can register and log in/out
   -users can create stores 
   -users can filter stores by name or category 
   -users can add products to their carts)
   
## Milestone 3:

* Fixed bugs
* Created an error page
* Handle errors in most of the input fields 
* attached car to user 
* a major bug was fixed (stores would not run out of stuck) 

