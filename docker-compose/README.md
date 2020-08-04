This is A FORK OF "compose-postgrest"
=================

Initially it didn't have the Spring Boot app, now the docker-compose also contains the "spring-data-rest" app that implements the "city" endpoint.

You can use the following commands to test the overall performance of the PostgREST and Spring Boot Data Rest.


```

# 10k requests, 50 concurrent calls, find all the cities with country code on Spring Boot App
ab -n 10000 -c 50 "http://172.0.0.1:9090/city/search/findByCountrycode?countrycode=TUR"

# 10k requests, 50 concurrent calls, find all the cities with country code on PostgREST
ab -n 10000 -c 50 "http://172.0.0.1:3000/city?countrycode=eq.TUR"

# 100 requests, 10 concurrent calls, find all the cities on Spring Boot App
ab -n 100 -c 10 "http://172.0.0.1:9090/city/search/findByPopulationGreaterThanEqual?population=1"

# 100 requests, 10 concurrent calls, find all the cities on PostgREST
ab -n 100 -c 10 "http://172.0.0.1:3000/city?population=gte.1"
```


Here are some results to compare.

```
Find all the cities
	PostgREST	Quarkus Reactive	SpringBoot Standard	Go App Standard
50.00%	144	607	2265	119
66.00%	178	622	2349	146
75.00%	191	634	2388	168
80.00%	202	643	2425	181
90.00%	224	664	2529	213
95.00%	243	683	2643	234
98.00%	256	698	2832	277
99.00%	274	714	2900	309
100.00%	329	785	3450	358
```
![Performance Diagram](diagrams/app-performances.png)


"compose-postgrest"
=================

[Postgres](https://www.postgresql.org/), [PostgREST](https://github.com/begriffs/postgrest), and [Swagger UI](https://github.com/swagger-api/swagger-ui) conveniently wrapped up with docker-compose.

Place SQL into the `initdb` folder, get REST! 
Includes [world sample database](http://pgfoundry.org/projects/dbsamples/).

Contains a simple front-end  demo application.

Architecture
------------

![Deployment Diagram](diagrams/deployment-diagram.png)

Usage
-----

**Start the containers**

`docker-compose up -d`

**Tearing down the containers**

`docker-compose down --remove-orphans -v`

**Demo Application**

Located at [http://localhost](http://localhost)

**Postgrest**

Located at [http://localhost:3000](http://localhost:3000)

Try things like:
* [http://localhost:3000/city](http://localhost:3000/test)
* [http://localhost:3000/country](http://localhost:3000/country)
* [http://localhost:3000/countrylanguage](http://localhost:3000/countrylanguage)
* [http://localhost:3000/city?name=eq.Denver](http://localhost:3000/city?name=eq.Denver)
* [http://localhost:3000/city?population=gte.5000000](http://localhost:3000/city?population=gte.5000000)
* [http://localhost:3000/city?district=like.*Island](http://localhost:3000/city?district=like.*Island)
* [http://localhost:3000/city?district=like.*Island&population=lt.1000&select=id,name](http://localhost:3000/city?district=like.*Island&population=lt.1000&select=id,name)

**Swagger UI**

Located at [http://localhost:8080](http://localhost:8080)