# Documentation

### Folders
1. Controllers: Contains the REST controllers that handle the HTTP requests to the server. Contains API endpoints to handle the requests.
2. Service: They perform the business logic - interacting with repositories and process data.
3. Repository: Interacts with database. Generally extends Jpa repositories. They perform CRUD operations over DBs.
4. Model: Contains the entity classes that represent structure of data in our db. Each entity corresponds to a table.
5. Config: Contains configuration logic - spring configurations, db configurations.
6. Resources: templates, static assets
7. application.properties: Define properties for db connections, logging levels, server setitings.
8. static: static resources like css, javascript, images
9. templates: template files.

### Some common Annotations used:
1. @Id: Specifies the primary key of the entity.
2. @strategy: Defines the strategy for JPA to generate the key. Here IDENTITY is used.
3. @OneToMany(mappedBy = "user", cascade = CascadeType.ALL).
   <br/> The mappedBy = "user" in the User entity indicates that the user field in the Task entity is the owner of the relationship (i.e., it contains the foreign key). CascadeType.ALL represents all lifecycle methods will be applied to all Task entities.
4. @Service: Indicates that a class is a service component in the spring application
5. @Autowired: Indicates that an auto dependency injection would be done here.
6. @PathVariable Long id: It will extract the id from the url.

### JPA
JPA stands for Java Persistence API. It simplifies teh way we handle the databases. It supports ORM. Thus, we are able to work with databases in OOP concepts.

### Repositories
Repositories are abstraction layer in Java that helps us to interact with the database without writing actual SQL queries. We can also define custom queries (eg. findByUserName) and JPA would itself implement such a query ina method
There are majorly two types of Repositories:
- CrudRepository: Helps to implement the basic CRUD operations.
- JpaRepository: It extends CrudRepository adding additional method including sorting and pagination capabilities.

### Response Entity
Response entity is a part of Spring framework that represents an HTTP response, including its status code, header, and body. 