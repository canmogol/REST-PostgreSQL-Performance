package main

import (
	"database/sql"
	"encoding/json"
	"fmt"
	"log"
	"net/http"

	"github.com/gorilla/mux"
	_ "github.com/lib/pq"
)

// City City
type City struct {
	ID          int    `json:"id"`
	Name        string `json:"name"`
	Countrycode string `json:"countrycode"`
	District    string `json:"district"`
	Population  int    `json:"population"`
}

// JSONResponse JSONResponse
type JSONResponse struct {
	Type    string `json:"type"`
	Data    []City `json:"data"`
	Message string `json:"message"`
}

var db *sql.DB

func main() {
	db = setupDB()
	router := mux.NewRouter()

	// Get all cities
	router.HandleFunc("/cities/", GetCitys).Methods("GET")

	// Create a city
	log.Fatal(http.ListenAndServe(":8001", router))
}

// GetCitys get all cities
func GetCitys(w http.ResponseWriter, r *http.Request) {

	// Get all cities from cities table that don't have cityID = "1"
	rows, err := db.Query("SELECT * FROM city")

	checkErr(err)

	var cities []City
	// var response []JSONResponse
	// Foreach city
	for rows.Next() {
		var id int
		var name string
		var countrycode string
		var district string
		var population int

		err = rows.Scan(&id, &name, &countrycode, &district, &population)

		checkErr(err)

		cities = append(cities, City{ID: id, Name: name, Countrycode: countrycode, District: district, Population: population})
	}

	rows.Close()

	var response = JSONResponse{Type: "success", Data: cities}

	json.NewEncoder(w).Encode(response)
}

// DB set up
func setupDB() *sql.DB {
	dbinfo := fmt.Sprintf("host=postgrest-db port=5432 user=postgres password=postgres dbname=postgres sslmode=disable")

	db, err := sql.Open("postgres", dbinfo)

	checkErr(err)

	return db
}

// Function for handling errors
func checkErr(err error) {
	if err != nil {
		panic(err)
	}
}
