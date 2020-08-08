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
                        if (env.GIT_BRANCH == 'origin/dev') {
                            echo 'Branch is dev'
                            bat "deploy_dev.sh"
                        }else if (env.GIT_BRANCH == 'origin/qa') {
                            echo 'Branch is qa'
                            bat "deploy_qa.sh"
                        } else if (env.GIT_BRANCH == 'origin/master') {
                            echo 'Branch is master'
                            bat "deploy_prod.sh"
                        }
                    }
                }
            }
        }
    }
}
