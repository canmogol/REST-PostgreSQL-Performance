## Python / Flask Application

This is a simple application that returns a JSON representation of the `city` table.

## How to Run

To run the sample application, first install Flask if you don't have;
```
http://flask.pocoo.org/docs/0.11/installation/
```

Also, you need to install the `flask`, `simplejson` and `psycopg2` libraries.

```
pip install flask
pip install simplejson
pip install psycopg2
# if you run into problems with psycopg2 library, you might need to install the binary using the following command
# pip install psycopg2-binary
```

run the following commands in the folder to start the server
```sh
export FLASK_APP=server.py
export FLASK_DEBUG=1
python -m flask run
```

and open below URL;
```
http://127.0.0.1:5000/
```

## Test Results

Please see the `project-webflux` Readme for the results.

