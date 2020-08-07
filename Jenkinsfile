pipeline {
    agent any
    environment{
        PROJECT_NAME = 'todo_list_backend'
    }
    tools {
        gradle 'gradle'
    }
    stages {
        stage('Build') {
            steps {
                bat "gradlew clean build"
            }
        }
        stage('Deploy') {
            steps {
                sh label: '', script: '''#!/bin/bash
                API_NAME="todo-list-backend"
                API_VERSION="0.0.1"
                API_PORT="8010"
                IMAGE_NAME=${API_NAME}:${API_VERSION}
                CONTAINER_NAME=${API_NAME}-${API_VERSION}

                docker stop `docker ps -a| grep ${IMAGE_NAME} | awk \'{print $1}\' `
                docker rm   `docker ps -a| grep ${IMAGE_NAME} | awk \'{print $1}\' `
                
                cp ./build/libs/*.jar ./deploy
                docker build -t ${IMAGE_NAME} .

                docker run --name ${CONTAINER_NAME} -d -p ${API_PORT}:8080 ${IMAGE_NAME}'''
            }
        }
    }
}
