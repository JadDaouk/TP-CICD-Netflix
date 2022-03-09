pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
        }
    }
    stages{
        stage('build'){
            sh'''
                mvm clean install
            '''
        }
        stage('launch jar'){
            sh'''
                java -jar  netflix-1.0.0.jar  ./netflix_titles.csv
            '''
        }
        stage('verify'){
        sh'''
            cd ./out
            ls
        '''
        }
    }
}