pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/helodeanmol/SeleniumBDDCucumber.git'
            }
        }
        stage('Build') {
            steps {
//                 sh 'mvn clean install'
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
//                 sh 'mvn test'
                bat 'mvn test'
            }
        }
        stage('Report') {
            steps {
                publishHTML([reportDir: 'target', reportFiles: 'ExtentReport.html', reportName: 'Extent Report'])
            }
        }
    }
    post {
        always {
            publishHTML([reportDir: 'target', reportFiles: 'ExtentReport.html', reportName: 'Extent Report'])
        }
    }
}
