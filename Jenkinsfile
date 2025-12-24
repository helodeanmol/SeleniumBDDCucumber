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
                script {
                    // get latest Run-* folder name under `test-output`
                    def latest = bat(returnStdout: true, script:
                        'powershell -NoProfile -Command "(Get-ChildItem -Directory -Path (Join-Path $env:WORKSPACE \\'test-output\\') | Where-Object { $_.Name -like \\'Run-*\\' } | Sort-Object Name -Descending | Select-Object -First 1).Name"'
                    ).trim()

                    if (!latest) {
                        error 'No Run-* folder found under `test-output`'
                    }

                    publishHTML(target: [
                        reportName: 'Extent Report',
                        reportDir: "test-output/${latest}",
                        reportFiles: 'index.html',
                        keepAll: true,
                        alwaysLinkToLastBuild: true
                    ])
                }
            }
        }
    }
}
