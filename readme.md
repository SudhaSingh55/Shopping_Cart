Project has h2 in memory database,

1) Get list of all products 
Get url : http://localhost:8080/product/list
Get List of products by Id
Get url : http://localhost:8080/product/list?productId=1
2) Add product
Post Url : http://localhost:8080/product/add
   {
   "productId":1,
   "productName":"Table",
   "quantity":100,
   "price":1000
   }
3) Delete Product
Get Url : http://localhost:8080/product/delete?productId=1