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
-> % ab -n 500 -c 20 "http://localhost:3000/city"
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


Server Software:        postgrest/7.0.1
Server Hostname:        localhost
Server Port:            3000

Document Path:          /city
Document Length:        393280 bytes

Concurrency Level:      20
Time taken for tests:   3.623 seconds
Complete requests:      500
Failed requests:        0
Write errors:           0
Total transferred:      196734000 bytes
HTML transferred:       196640000 bytes
Requests per second:    138.01 [#/sec] (mean)
Time per request:       144.913 [ms] (mean)
Time per request:       7.246 [ms] (mean, across all concurrent requests)
Transfer rate:          53031.19 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       1
Processing:    23  143  62.4    144     329
Waiting:       22  141  62.0    141     326
Total:         23  143  62.5    144     329

Percentage of the requests served within a certain time (ms)
  50%    144
  66%    178
  75%    191
  80%    202
  90%    224
  95%    243
  98%    256
  99%    274
 100%    329 (longest request)





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
Time taken for tests:   15.308 seconds
Complete requests:      500
Failed requests:        0
Write errors:           0
Total transferred:      190548500 bytes
HTML transferred:       190523000 bytes
Requests per second:    32.66 [#/sec] (mean)
Time per request:       612.303 [ms] (mean)
Time per request:       30.615 [ms] (mean, across all concurrent requests)
Transfer rate:          12156.24 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.2      0       2
Processing:    47  598  75.0    607     784
Waiting:       41  595  74.9    603     782
Total:         48  598  74.9    607     785

Percentage of the requests served within a certain time (ms)
  50%    607
  66%    622
  75%    634
  80%    643
  90%    664
  95%    683
  98%    698
  99%    714
 100%    785 (longest request)



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
Time taken for tests:   56.815 seconds
Complete requests:      500
Failed requests:        0
Write errors:           0
Total transferred:      649045000 bytes
HTML transferred:       648946000 bytes
Requests per second:    8.80 [#/sec] (mean)
Time per request:       2272.608 [ms] (mean)
Time per request:       113.630 [ms] (mean, across all concurrent requests)
Transfer rate:          11156.05 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       1
Processing:   713 2240 291.8   2265    3450
Waiting:      118 1550 262.7   1565    2674
Total:        713 2240 291.8   2265    3450

Percentage of the requests served within a certain time (ms)
  50%   2265
  66%   2349
  75%   2388
  80%   2425
  90%   2529
  95%   2643
  98%   2832
  99%   2900
 100%   3450 (longest request)



############################################################
# GO APP - STANDARD IMPLEMENTATION
############################################################
-> % ab -n 500 -c 20 "http://localhost:8001/cities/"
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
Server Port:            8001

Document Path:          /cities/
Document Length:        381341 bytes

Concurrency Level:      20
Time taken for tests:   3.220 seconds
Complete requests:      500
Failed requests:        0
Write errors:           0
Total transferred:      190719000 bytes
HTML transferred:       190670500 bytes
Requests per second:    155.27 [#/sec] (mean)
Time per request:       128.810 [ms] (mean)
Time per request:       6.441 [ms] (mean, across all concurrent requests)
Transfer rate:          57836.66 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       1
Processing:    18  127  61.5    119     358
Waiting:       18  124  61.7    117     357
Total:         18  127  61.5    119     358

Percentage of the requests served within a certain time (ms)
  50%    119
  66%    146
  75%    168
  80%    181
  90%    213
  95%    234
  98%    277
  99%    309
 100%    358 (longest request)

