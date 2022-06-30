#!/bin/sh
# Tests should be trigger using this shell script so the db can be repopulated

# Creating a new mock database
if [ -f dbjson/db_original.json ]; then
  echo "Original mock db exists - deploying snapshot"
  cp dbjson/db_original.json dbjson/db.json
else
  echo "Original mock db doesn't exist!"
  echo "Tests will fail"
fi

# Starting the database
json-server --watch dbjson/db.json &