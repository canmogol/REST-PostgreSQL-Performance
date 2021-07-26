# Spring WebFlux

Why was Spring WebFlux created?

Part of the answer is the need for a non-blocking web stack to handle concurrency 
with a small number of threads and scale with fewer hardware resources.

**How to Compile**

You can compile the project only by running the `mvnw` command line script.

On *nix environment you may run the `mvnw` shell script,
```bash
./mvnw clean install
```

On Windows environment you may run the `mvnw.cmd` command.
```bash
mvnw.cmd clean install
```

**How to Native Compile**

You can compile this Spring WebFlux application to a native executable.

In order compile to native executable, you need to install the Graalvm and `native-image` command.

You can use SdkMan to install and configure JDKs.

```
# install sdkman
curl -s "https://get.sdkman.io" | bash

# initialize sdkman on the current shell session
source "$HOME/.sdkman/bin/sdkman-init.sh"

# install Graalvm Java 11
sdk install java 21.1.0.r11-grl

# install native image tool
gu install native-image
```

This command will create a native executable under the `target` folder.
```
mvn -Pnative -DskipTests package
```

**How to Run**

You'll need a PostgreSQL instance with some data in it. You can use the `postgres-docker-compose.yml` file under the `docker-compose` folder.

First you need to run the docker-compose on the `postgres-docker-compose.yml` file, it should create a PostgreSQL instance with the necessary `city` table and data. 

```
cd ../docker-compose
docker-compose -f postgres-docker-compose.yml up
```

## Test Results

The following are the measurements on memory, cpu and avarage response times for `project-webflux` as Java and Native compiled Java application with the `go-postgresql-rest` application as the Go application.

The average startup time for the Java application is 2.5 seconds, after compiling to native the average is around 90ms, similar to the Go application.

Here is the `ab` command used in the test, first 1000 requests are discarded.
```
for i in {1..100}; do ab -n 500 -c 20 "http://localhost:8080/city/" ; sleep 1; done
```

### The Average Response Times
Java, Native compiled Java and Go application results.
```
Percent,	Java Response AVR (ms), 	Native Response AVR (ms),	Go AVR Response
50%	    265.75	615.5	138.25
66%	    298.25	655.25	171
75%	    320.5	697.75	189.75
80%	    334.25	725.5	201
90%	    378.25	784.75	234.75
95%	    412.25	850	    262.75
98%	    458.25	934	    298
99%	    480.25	982	    354
100%	534.5	1073.5	467.75
```

![Average Repsonse Time](images/average-response-time.png "Average Repsonse Time")




### The Memory Percentages
Java, Native compiled Java and Go application results.
These values are of 16GB of memory, therefore;
* 5,5 percent approximately equals to **900MB**
* 4,5 percent approximately equals to **737MB** 
* 0.25 percent approximately equals to **40MB**

```
Java Memory %	Native Memory %	GO Memory %
5.37	3.39	0.21
5.39	3.56	0.22
5.4	    3.76	0.23
5.4	    3.92	0.23
5.41	4.16	0.23
5.41	4.32	0.23
5.42	4.49	0.24
5.43	4.5	    0.24
5.44	4.54	0.24
5.44	4.5	    0.24
5.44	4.54	0.24
5.45	4.5	    0.24
5.45	4.54	0.24
5.46	4.5	    0.24
5.46	4.53	0.24
5.47	4.48	0.24
5.48	4.49	0.24
5.48	4.5	    0.24
5.48	4.47	0.24
5.48	4.51	0.24
5.49	4.54	0.24
5.51	4.51	0.24
5.51	4.55	0.24
5.52	4.5	    0.24
5.52	4.54	0.24
5.52	4.5	    0.24
5.52	4.53	0.24
5.53	4.49	0.24
5.53	4.53	0.24
5.55	4.49	0.24
5.57	4.52	0.24
5.57	4.49	0.24
5.59	4.55	0.24
5.59	4.51	0.24
5.59	4.55	0.24
5.6	    4.51	0.24
5.6	    4.55	0.24
5.6	    4.51	0.24
5.6	    4.54	0.24
5.6	    4.49	0.25
5.61	4.54	0.25
5.61	4.5	    0.25
5.61	4.53	0.25
5.61	4.49	0.25
5.61	4.53	0.25
5.61	4.48	0.25
5.63	4.51	0.25
5.63	4.48	0.25
5.63	4.52	0.25
5.63	4.54	0.25
5.64	4.54	0.25
5.64	4.51	0.25
5.64	4.54	0.25
5.65	4.5	    0.25
5.65	4.53	0.25
5.65	4.5	    0.25
5.65	4.52	0.25
5.65	4.48	0.25
5.65	4.52	0.25
5.65	4.48	0.25
5.65	4.52	0.25
5.65	4.48	0.25
```

![Memory Percentages](images/memory-percentages.png "Memory Percentages")



### The CPU Percentages
Java, Native compiled Java and Go application results.
```
Java,	Native, Go
1	100	94
100	100	100
100	100	100
100	100	100
100	100	100
100	100	42
100	100	100
100	100	100
100	100	100
78	100	100
100	100	57
100	100	100
100	100	100
100	100	100
100	100	100
100	100	100
100	100	100
100	100	100
16	100	100
100	100	56
100	100	100
100	100	100
100	100	100
100	100	100
100	100	30
100	100	100
24	100	100
100	100	100
100	100	100
100	100	90
100	100	100
100	100	100
100	100	100
100	100	93
100	100	100
100	100	100
100	100	100
100	100	100
100	100	33
100	100	100
100	100	100
100	100	100
100	100	100
100	100	47
100	100	100
100	100	100
100	100	100
100	100	100
100	57	100
100	100	100
100	100	100
100	100	100
100	100	83
100	100	100
100	100	100
100	100	100
100	100	100
100	100	30
88	100	100
100	100	100
81	100	100
```

![CPU Percentages](images/cpu-percentages.png "CPU Percentages")




