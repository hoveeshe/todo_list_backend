pipeline {
    agent any
    environment{
        PROJECT_NAME = 'todo_list_backend'
    }
    tools {
        gradle 'gradle'
    }
    stages {
        stage('Pull') {
            steps {
                git credentialsId: '78dde4b7-42ed-4583-8224-b284c5a8b27e', url: 'https://github.com/ita2020hovees/todo_list_backend.git'
            }
        }
        stage('Build') {
            steps {
                bat "gradlew clean build"
            }
        }
        stage('Deploy') {
            steps {
                bat 'deploy.bat'
            }
        }
    }
}
