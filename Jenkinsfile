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
                mvn clean install
                '''
            }
        }
        stage('test') {
            steps {
                sh '''
                mvn clean test surefire-report:report
                '''
            }
        }
        stage('test results') {
            steps {
                junit '**/target/surefire-reports/TEST-*.xml'
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
                rm -rf /out/*
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