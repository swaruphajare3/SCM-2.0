pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/swaruphajare3/SCM-2.0.git'
            }
        }

        stage('Stop Old Containers') {
            steps {
                bat '''
                docker-compose down || echo No containers running
                '''
            }
        }

        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Run App with Docker Compose') {
            steps {
                bat '''
                docker-compose up -d --build
                '''
            }
        }
    }
}
