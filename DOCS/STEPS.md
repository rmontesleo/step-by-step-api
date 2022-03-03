# Step by Step API

## Step 0: Create a basic API
    - Create your SpringBoot project with Initializer
    - Add the dependencies of web, jpa and h2
    - Add the Controller annotation in the main class
    - Add some methods using the annotations of GetMapping, PostMapping, DeleteMapping, PutMapping

## Step 1: Create a controller
    - Create a controller class with the Controller annotation
    - clean the main class
    - Use th ResponseEntity class to send code from your methods
    - Use a RequestMapping to define your routes
    - Define the classes you will use in each operation
    - With a ArrayList simulate a database
    - With the stream method use high order functions, to implement the filter, map, findFirst methods

## Step 2: Create a Service
    - Create a service class with the Service annotation
    - Implement the crud methods in the service class.
    - modify the controller implementation to delegate the CRUD logic to the service class.
    - Inject the service with the Autowired annotation.

## Step 3: Create your repository
    - Create your Repository `Interface` that extends from JPARepository
    - The clas that is mapped with the database , add the required annotations to use with JPA
    - setup the application.yaml to configure your datasource
    - setup the application.yaml to configure your server
    - Modify your service to inject the repository
     
## Step 4: Add logging to your application
    - Implement the toString method in your entity
    - Use the Log and LogFactory from apache commons logging
    - use the methods for error, warn, info and debug
    - modify the logging levels in the appliction.yaml file
    - Test your logs in your classes
    - Add color to the console output

## Step 5: Improve your api:  Derived and Query methods (for Repository)  and Request Parms (for controller)
    - Clean up the logs . Set only the required ones.
    - Derive methods and Transactional
    - Query methods
    - RequestParam (query params)
    - import.sql file

## Step 6: Environment Variables
    - clean up Autowired annotation
    - setup launch.json from add configuration
    - decalre environment varibles
    - read environment variables in yaml or code