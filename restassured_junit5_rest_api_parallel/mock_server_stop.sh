#!/bin/sh
# Get node js proc id
proc_nr=`pgrep node`

if [ "${proc_nr}" = "" ]; then

  echo "Process id for Node not found"
else
  echo "Killing node proc id - ${proc_nr}"

  # Killing the node js proc id
  kill -9 "${proc_nr}"
fi