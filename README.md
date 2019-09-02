**A simple application built on Spring and REST that is used to store information about JavaScript frameworks**

Descriptions REST API methods

Route | Method | Descriptions 
----- | ------ | -----------
 /framework/create | POST | create JavaScriptFramework entities
 /frameworks | GET | find all entities
 /frameworks/name/value | GET | find by name entity
 /frameworks/version/value | GET | find by version entity
 /frameworks/update/ | PUT | update entity
 /framework/delete/id/value | DELETE | deleting entity

***

Samples
1. Create entites
request
{
	"name": "ReactJS",
  	"version": "1.0.0",
  	"deprecationDate": "2019-11-01",
  	"hypeLevel": 9
}
response

2. Find all 



3. Find by Name 
