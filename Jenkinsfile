pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/swaruphajare3/SCM-2.0.git'
            }
        }

        stage('Stop Old App') {
            steps {
                bat '''
                echo Stopping old application if running...
                taskkill /F /IM java.exe /T || echo No running app
                '''
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean verify'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Run App') {
            steps {
                bat '''
                echo Starting new application...
                start /B java -jar target\\scm2.0-0.0.1-SNAPSHOT.jar
                '''
            }
        }
    }
}
