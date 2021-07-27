#!/usr/bin/python
from flask import Flask, request, make_response, redirect, Response
import simplejson as json
import psycopg2

conn = psycopg2.connect("host=centos dbname=postgres user=postgres password=postgres")

app = Flask(__name__, static_url_path='')

@app.route("/city")
def city():
    cursor = conn.cursor()
    cursor.execute("SELECT * from city")
    results=cursor.fetchall()
    cursor.close()
    return Response(json.dumps(results), mimetype='application/json')

if __name__ == "__main__":
    app.run()
