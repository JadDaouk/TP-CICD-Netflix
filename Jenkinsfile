pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
        }
    }
    stages {
        stage('build') {
            steps {
                sh '''
                mvn clean install test surefire-report:report
                '''
            }
        }
        stage('launch jar') {
            steps {
                sh '''
                java -jar  ./target/netflix-1.0.0.jar  ./netflix_titles.csv
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
        stage('mv to out') {
            steps {
                sh '''
                rm /out/*
                mv ./out/* /out
                '''
            }
        }
        stage('clear') {
             steps {
                  cleanWs deleteDirs: true
             }
        }
    }
}