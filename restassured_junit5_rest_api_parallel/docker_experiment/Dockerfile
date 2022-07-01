# syntax=docker/dockerfile:1
FROM node:latest

RUN npm install -g json-server

COPY db_original.json db_original.json
COPY run.sh run.sh

ENTRYPOINT ["bash", "/run.sh"]


#CMD ["bash", "cp", "db_original.json", "db.json"]

#CMD ["json-server", "--port", "3000", "--host", "0.0.0.0", "--watch", "db.json"]


