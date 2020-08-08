#!/bin/bash
API_NAME="todo_list_backend_master"
API_VERSION="0.0.1"
API_PORT="8020"
IMAGE_NAME=${API_NAME}:${API_VERSION}
CONTAINER_NAME=${API_NAME}-${API_VERSION}
DOCKER_FILE="./deploy/Dockerfile"

docker rm -f ${CONTAINER_NAME}

echo "**Init dockerfile start: "${DOCKER_FILE}
echo "FROM tomcat" > ${DOCKER_FILE}
echo 'MAINTAINER hovees "hovees.cn"' >> ${DOCKER_FILE}
echo "ADD *.jar app.jar" >> ${DOCKER_FILE}
echo "EXPOSE 8080" >> ${DOCKER_FILE}
echo 'ENTRYPOINT ["java","-jar","app.jar"]' >> ${DOCKER_FILE}
cat ${DOCKER_FILE}
echo "**Init dockerfile end."

echo "##Build dockerfile for "${IMAGE_NAME}
cp ../build/libs/*.jar ./
docker build -t ${IMAGE_NAME} .

docker run --name ${CONTAINER_NAME} -d -p ${API_PORT}:8080 ${IMAGE_NAME}