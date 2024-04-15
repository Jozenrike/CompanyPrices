- The project basically retrieves the price of a product, for a concrete brand in a concrete date( in case of multiple rows the field PRIORITY decides the response)
- Techs used for the project: Java 21(openjdk), maven and jpa/hibernate, h2 mem database
- To execute an example all we need to do is clone the project(git clone), launch maven compile(mvn clean compile) y deploy the app. 
    Once we have that we can just throw a postman request to, for example, {DOMAIN}:{PORT}//prices?productId=1&brandId=1&applyDate=2024-05-24T17:32:28Z(openapi.yaml can be imported to postman directly)
- There are 3 prices already in the in-memory h2 database in data.sql