pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
        }
    }
    stages{
        stage('build'){
            step{
                sh '''
                mvm clean install
                '''
            }
        }
        stage('launch jar'){
            step{
                sh '''
                java -jar  netflix-1.0.0.jar  ./netflix_titles.csv
                '''
            }
        }
        stage('verify'){
            step{
                sh '''
                cd ./out
                ls
                '''
            }
        }
    }
}