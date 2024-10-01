# Documentation

### Folders
1. **Controllers**: Contains the REST controllers that handle the HTTP requests to the server. Contains API endpoints to handle the requests.
2. **Service**: They perform the business logic - interacting with repositories and process data.
3. **Repository**: Interacts with database. Generally extends Jpa repositories. They perform CRUD operations over DBs.
4. **Model**: Contains the entity classes that represent structure of data in our db. Each entity corresponds to a table.
5. **Config**: Contains configuration logic - spring configurations, db configurations.
6. **Resources**: templates, static assets
7. **application.properties**: Define properties for db connections, logging levels, server setitings.
8. **static**: static resources like css, javascript, images
9. **templates**: template files (if using themeleaf etc.)
10. **security**: contains the jwt authentication logic.

### Some common Annotations used:
1. **@Id**: Specifies the primary key of the entity.
2. **@strategy**: Defines the strategy for JPA to generate the key. Here IDENTITY is used.
3. **@OneToMany**(mappedBy = "user", cascade = CascadeType.ALL).
   <br/> The mappedBy = "user" in the User entity indicates that the user field in the Task entity is the owner of the relationship (i.e., it contains the foreign key). CascadeType.ALL represents all lifecycle methods will be applied to all Task entities.
4. **@Service**: Indicates that a class is a service component in the spring application
5. **@Autowired**: Indicates that an auto dependency injection would be done here.
6. **@PathVariable**: It will extract the id from the url.
7. **@Configuration**: Indicates that the file is a config file. Spring would look for config beans inside it.
8. **@EnableWebSecurity**: Enables spring security for the application.
9. **@Component**: Marks the class as a spring managed component.
10. **@Value**: Loads the value defined in the application.properties

### JPA
JPA stands for Java Persistence API. It simplifies teh way we handle the databases. It supports ORM. Thus, we are able to work with databases in OOP concepts.

### Repositories
Repositories are abstraction layer in Java that helps us to interact with the database without writing actual SQL queries. We can also define custom queries (eg. findByUserName) and JPA would itself implement such a query ina method
There are majorly two types of Repositories:
- CrudRepository: Helps to implement the basic CRUD operations.
- JpaRepository: It extends CrudRepository adding additional method including sorting and pagination capabilities.

### Response Entity
Response entity is a part of Spring framework that represents an HTTP response, including its status code, header, and body. 

### Some important authentication modules:
1. **spring-boot-starter-security**: Provides the core security features like authentication and authorization.
2. **spring-security-core**: Contains security related components like UserDetailsService and PasswordEncoder.
3. **spring-security-config**: Allows us to configure and customize spring security for specific application needs.

### User authentication
1. Adding the dependency of Spring Security.
2. Creating a security config file.
    - Dependency Injection: *userDetailsService* A custom user details service for loading user related data from database. _JwtAuthenticationEntryPoint_ It handles any exceptions during the process of jwt authentication. _JwtAuthenticationFilter_ filters incoming requests validating the jwt tokens.
    - Password Encoder Bean defines how the password will be encrypted. Here, by Bcrypt.
    - SecurityFilterChain: Defines the main security settings.   
            a. CSRF disabled. Disables Cross-Site Request Forgery (CSRF) protection, as it's unnecessary when using stateless authentication (JWT).
            b. authorizeRequests define which requests to allow without authentication. 
            c. and().exceptionHandling: handle authentication failures.
            d. sessionManagement: configures the server using stateless policy.
            e. adds jwt validation filter before password verification.
3. Implementing UserDetails in User entity. This is a core interface that represents the user trying to authenticate. It has methods like getUsername, getAuthorities etc.
4. Implement UserDetailsService to retrieve the user details from the database. We make a custom one and implement it. It invokes loadUserByName method from our custom implementation. If found returns our User (implementing userDetails) or else userNameNotFoundException. 
5. JwtAuthenticationEntryPoint implements AuthenticationEntryPoint interface. It is used to handle unauthenticated user accesses.
   - Commence method is invoked whenever an authentication error occurs.
   - Accepts the response, request and authException.
   - Returns the authException error.
6. JwtAuthenticationFilter extends spring's oncePerRequestFilter. It does the jwt authentication in every request.
   - _jwtHelper_ is dependency injection of helper class.
   - _userDetailsService_ is used to load user data.
   - PUBLIC_URLs list out all the URLs that don't require jwt authentication.
   - _doFilterInternal_ method contains the core logic of filtering the requests. 
   - _SecurityContextHolder_ holds the authenticated user token for current requests. If validation is successful, an UsernamePasswordAuthenticationToken is created, setting the authentication in the SecurityContextHolder so that the user is authenticated for the current request.
   - filterChain.doFilter(request, response); continues the request through other filters or handlers.
7. JwtHelper contains the utility methods for jwt authentication. 
   - _getClaimFromToken_ is a generic method to get a particular claim from the jwt token.
   - _getAllClaimsFromToken_ parses the jwt token and gets the body.
   - _doGenerateToken_ generates the token using jwt builder.
   - _validateToken_ validates the token by checking the username and ensuring its it has not expired.

### Bean
Bean is an object maintained by Spring. They are building blocks of a spring application. They are created, configured, and managed by Spring, allowing developers to focus on defining the behavior and relationships between these components.

### Data Transfer Object
A DTO is a java object used to transfer data between different layers of an application. Here, we have used a dto for login request to represent the info the user would send for authentication.

