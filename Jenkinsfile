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
                echo Stopping app running on port 8081...

                for /f "tokens=5" %%a in ('netstat -aon ^| findstr :8081') do (
                    echo Killing process %%a
                    taskkill /F /PID %%a
                )

                echo Done stopping old app
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
