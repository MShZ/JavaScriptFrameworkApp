**A simple application built on Spring and REST that is used to store information about JavaScript frameworks**

Descriptions REST API methods

Route | Method | Descriptions 
----- | ------ | -----------
 /framework/create | POST | create entities
 /frameworks | GET | find all entities
 /frameworks/name/value | GET | find by name entity
 /frameworks/version/value | GET | find by version entity
 /frameworks/update/ | PUT | update entity
 /framework/delete/id/value | DELETE | deleting entity

***

**1. Create entites**

```request``` 
```json 
{
	"name": "ReactJS",
  	"version": "1.0.0",
  	"deprecationDate": "2019-11-01",
  	"hypeLevel": 9
}
```

```response``` 
```json
{
    "recordId": 1,
    "result": 0,
    "errorText": ""
}
```

**2. Find all entities**

```response``` 
```json
[
    {
        "id": 1,
        "name": "ReactJS",
        "version": "1.0.0",
        "deprecationDate": "2019-11-01",
        "hypeLevel": 9
    },
    {
        "id": 2,
        "name": "VueJS",
        "version": "5.0.0",
        "deprecationDate": "2019-11-01",
        "hypeLevel": 9
    }
]
```

**3. Find by name entity**

```request``` 
```html 
/frameworks/name/ReactJS
```

```response``` 
```json
[
    {
        "id": 1,
        "name": "ReactJS",
        "version": "1.0.0",
        "deprecationDate": "2019-11-01",
        "hypeLevel": 9
    },
    {
        "id": 3,
        "name": "ReactJS",
        "version": "3.0.0",
        "deprecationDate": "2019-11-01",
        "hypeLevel": 9
    }
]
```

**4. Find by version entity**

```request``` 
```html 
/frameworks/version/1.0.0
```

```response``` 
```json
[
    {
        "id": 1,
        "name": "ReactJS",
        "version": "1.0.0",
        "deprecationDate": "2019-11-01",
        "hypeLevel": 9
    }
]
```

**5. Update entity**

```request``` 
```json 
 {
        "id": 1,
        "name": "ReactJS",
        "version": "2.0.0",
        "deprecationDate": "2020-11-01",
        "hypeLevel": 1
}
```

```response``` 
```json
{
    "recordId": 1,
    "result": 0,
    "errorText": ""
}
```

**6. Deleting entity**

```request``` 
```html 
/framework/delete/id/1
```

```response``` 
```json
{
    "recordId": 0,
    "result": 0,
    "errorText": ""
}
```
