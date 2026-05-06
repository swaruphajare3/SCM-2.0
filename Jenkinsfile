pipeline {
    agent any

    environment {
        IMAGE_NAME = "scm-app"
        CONTAINER_NAME = "scm-container"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/swaruphajare3/SCM-2.0.git'
            }
        }

        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Stop Old Container') {
            steps {
                bat 'docker rm -f %CONTAINER_NAME% || echo No container'
            }
        }

        stage('Run Container') {
            steps {
                bat '''
                docker run -d -p 8081:8080 --name %CONTAINER_NAME% %IMAGE_NAME%
                '''
            }
        }
    }
}
