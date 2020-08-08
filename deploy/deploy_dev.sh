#!/bin/bash
API_NAME="todo_list_backend_dev"
API_VERSION="0.0.1"
API_PORT="8010"
IMAGE_NAME=${API_NAME}:${API_VERSION}
CONTAINER_NAME=${API_NAME}-${API_VERSION}

docker rm -f ${CONTAINER_NAME}

cp ../build/libs/*.jar ./
docker build -t ${IMAGE_NAME} .

docker run --name ${CONTAINER_NAME} -d -p ${API_PORT}:8080 ${IMAGE_NAME}