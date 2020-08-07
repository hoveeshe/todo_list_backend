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
                dir('deploy') {
                    sh "deploy.sh"
                }
            }
        }
    }
}
