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
                mvn test surefire-report:report
                '''
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
        stage('deploiment') {
            steps {
                sshPublisher(
                                   continueOnError: false, failOnError: true,
                                   publishers: [
                                     sshPublisherDesc(
                                      configName: "rousseau_server",
                                      verbose: true,
                                      transfers: [
                                       sshTransfer(
                                        sourceFiles: "out/*",
                                        remoteDirectory: "/"
                                       ),
                                        sshTransfer(
                                        sourceFiles: "out/movies/*",
                                        remoteDirectory: "/movies"
                                        )
                                      ])
                                   ]
                                )
            }
        }
        stage('sonarQube') {
            steps {
            step( [ $class: 'JacocoPublisher' ] )
                withSonarQubeEnv('SonarQube greg') {
                sh '''
                mvn verify sonar:sonar
                '''
                }
            }
        }
        stage('clear') {
             steps {
                  cleanWs deleteDirs: true
             }
        }
    }
}