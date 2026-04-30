pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/swaruphajare3/SCM-2.0.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

       stage('Run') {
    steps {
        bat 'dir target'
        bat 'java -jar target\\scm2.0-0.0.1-SNAPSHOT.jar'
    }
}
    }
}
