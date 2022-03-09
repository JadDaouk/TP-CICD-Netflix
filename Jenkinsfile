pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            reuseNode true
        }
    }
    stages {
        stage('build') {
            steps {
                sh '''
                mvm clean install
                '''
            }
        }
        stage('launch jar') {
            steps {
                sh '''
                java -jar  netflix-1.0.0.jar  ./netflix_titles.csv
                '''
            }
        }
        stage('verify') {
            steps {
                sh '''
                cd ./out
                ls
                '''
            }
        }
    }
}