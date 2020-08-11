# FatJar No Hibernate

You can build the project with this command,

```
mvn clean install 
```

Use the following command to start the application with its database.

```
docker-compose -f fatjar-postgresql-docker-compose.yml up
```

Also, you can use the 'ab' command to test the backend, do not forget to run the test multiple times.

```
ab -n 500 -c 20 "http://localhost:8091/city"
```
