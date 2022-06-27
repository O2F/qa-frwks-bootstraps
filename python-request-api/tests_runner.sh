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
sleep 0.1

# Code lint - only for local
if [ "$1" == "lint" ]; then
  flake8 tests/ --count --select=E9,F63,F7,F82 --show-source --statistics
  flake8 tests/ --count --exit-zero --max-complexity=10 --max-line-length=127 --statistics
fi

# Run tests
pytest tests/

# Get node js proc id
proc_nr=`pgrep node`

echo "Killing node proc id - ${proc_nr}"

# Killing the node js proc id
kill -9 "${proc_nr}"