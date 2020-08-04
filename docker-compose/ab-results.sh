############################################################
# 500 requests with 20 concurrency
############################################################

See the following statistics for each application.
"Time taken for tests"
"Time per request (mean)"
"Percentage of the requests served within a certain time (ms)"





############################################################
# PostgREST CONTAINER 
############################################################
-> % ab -n 500 -c 20 "http://localhost:9090/city"                                                     
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 100 requests
Completed 200 requests
Completed 300 requests
Completed 400 requests
Completed 500 requests
Finished 500 requests


Server Software:        
Server Hostname:        localhost
Server Port:            9090

Document Path:          /city
Document Length:        6914 bytes

Concurrency Level:      20
Time taken for tests:   1.416 seconds
Complete requests:      500
Failed requests:        0
Write errors:           0
Total transferred:      3556000 bytes
HTML transferred:       3457000 bytes
Requests per second:    353.07 [#/sec] (mean)
Time per request:       56.645 [ms] (mean)
Time per request:       2.832 [ms] (mean, across all concurrent requests)
Transfer rate:          2452.22 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       1
Processing:     9   55  29.3     50     238
Waiting:        8   45  24.0     41     190
Total:          9   55  29.3     50     238

Percentage of the requests served within a certain time (ms)
  50%     50
  66%     60
  75%     67
  80%     72
  90%     86
  95%    110
  98%    142
  99%    176
 100%    238 (longest request)




############################################################
# QUARKUS REACTIVE REST API - REACTIVE POSTGRESQL - NATIVE COMPILED
############################################################
-> % ab -n 500 -c 20 "http://localhost:8080/city"
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 100 requests
Completed 200 requests
Completed 300 requests
Completed 400 requests
Completed 500 requests
Finished 500 requests


Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /city
Document Length:        381046 bytes

Concurrency Level:      20
Time taken for tests:   14.346 seconds
Complete requests:      500
Failed requests:        0
Write errors:           0
Total transferred:      190548500 bytes
HTML transferred:       190523000 bytes
Requests per second:    34.85 [#/sec] (mean)
Time per request:       573.850 [ms] (mean)
Time per request:       28.692 [ms] (mean, across all concurrent requests)
Transfer rate:          12970.82 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.3      0       2
Processing:    40  561  76.8    571     705
Waiting:       37  558  76.6    568     699
Total:         42  561  76.6    571     705

Percentage of the requests served within a certain time (ms)
  50%    571
  66%    584
  75%    597
  80%    603
  90%    626
  95%    642
  98%    653
  99%    670
 100%    705 (longest request)



############################################################
# SPRING BOOT DATA REST - STANDARD IMPLEMENTATION
############################################################
-> % ab -n 500 -c 20 "http://localhost:9090/city/search/findByPopulationGreaterThanEqual?population=0"
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 100 requests
Completed 200 requests
Completed 300 requests
Completed 400 requests
Completed 500 requests
Finished 500 requests


Server Software:        
Server Hostname:        localhost
Server Port:            9090

Document Path:          /city/search/findByPopulationGreaterThanEqual?population=0
Document Length:        1297892 bytes

Concurrency Level:      20
Time taken for tests:   57.713 seconds
Complete requests:      500
Failed requests:        0
Write errors:           0
Total transferred:      649045000 bytes
HTML transferred:       648946000 bytes
Requests per second:    8.66 [#/sec] (mean)
Time per request:       2308.506 [ms] (mean)
Time per request:       115.425 [ms] (mean, across all concurrent requests)
Transfer rate:          10982.57 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       1
Processing:   703 2278 322.1   2303    3953
Waiting:      128 1579 294.2   1610    3042
Total:        703 2278 322.1   2303    3953

Percentage of the requests served within a certain time (ms)
  50%   2303
  66%   2382
  75%   2437
  80%   2466
  90%   2547
  95%   2636
  98%   2806
  99%   3359
 100%   3953 (longest request)
