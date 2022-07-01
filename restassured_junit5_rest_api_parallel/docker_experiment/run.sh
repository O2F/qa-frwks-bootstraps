#!/bin/bash

cp db_original.json db.json

#rgs= "--port 3000 --host 0.0.0.0 -watch db.json"

json-server -p 3000 -H 0.0.0.0 -w db.json