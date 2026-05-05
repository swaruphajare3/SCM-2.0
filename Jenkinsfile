pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/swaruphajare3/SCM-2.0.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean verify'
            }
        }

        stage('Package') {
            steps {
                bat 'dir target'
            }
        }
    }
}
