# ProjectForReview
This has been divided into two projects
1) MyRetail - 
a) Provides GET API-
   This is the API which will provide the Name information as the redsky.target URL provided was not working. Hence I created get mapping with /product/{id} as URI. This fetches
   the product ID from SQLServer Studio DB and returns to caller
b) Provides Pricing Information-
   This also has API to provide price information to the caller. The pricing information is fetched from SQLServer Studio DB and returned to caller
   
2) TargetConsumer- 
   This is the consumer class for the above mentioned APIs. Upon invoking GET( /products/id ) as mentioned in the case study MyRetail APIs are called and product name and price
   details are fetched , combined response is returned to client. Similarly with POST and PUT calls resources are created by invoking MyRetail APIs 
   
   Postman has been used for testing
