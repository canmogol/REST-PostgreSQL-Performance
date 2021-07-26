const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");

var process = require('process')
process.on('SIGINT', () => {
  process.exit(0)
})

const app = express();

app.use(cors());
app.use(bodyParser.json());

const Pool = require("pg").Pool;
const pool = new Pool({
  user: process.env.PG_USER,
  host: process.env.PG_HOST,
  database: process.env.PG_DB,
  password: process.env.PG_PASSWORD,
  port: 5432
});

app.get("/city", (req, res) => {
    pool.query(
      "SELECT * FROM city",
      [],
      (error, results) => {
        if (error) {
          throw error;
        }
        res.status(200).json(results.rows);
      }
    );
  });

app.listen(7070, () => {
  console.log(`Server is running.`);
});
