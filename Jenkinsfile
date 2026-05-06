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

        stage('Stop Old App') {
            steps {
                bat '''
                echo Stopping old application if running...
               taskkill /F /FI "WINDOWTITLE eq java*" || echo No app found
                '''
            }
        }

       stage('Run App') {
    steps {
        bat '''
        echo Stopping old app...
        taskkill /FI "WINDOWTITLE eq SCM_APP*" /F || echo No app

        echo Starting app in background...
        start "SCM_APP" cmd /c "java -jar target\\scm2.0-0.0.1-SNAPSHOT.jar > app.log 2>&1"
        '''
    }
}
        }
    }
}
