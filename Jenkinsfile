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
                    script {
                        if (env.BRANCH_NAME == 'master') {
                            echo 'branch is master'
                            bat "deploy_master.sh"
                        } else if (env.BRANCH_NAME == 'dev') {
                            echo 'branch is dev'
                            bat "deploy_dev.sh"
                        }
                    }
                }
            }
        }
    }
}
