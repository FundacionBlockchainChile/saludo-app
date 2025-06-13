pipeline {
    agent any

    tools {
        maven 'Maven' // Debe coincidir con el nombre configurado en Jenkins (Global Tool Configuration)
        jdk 'JDK21'    // O el nombre del JDK que configuraste en Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/FundacionBlockchainChile/saludo-app.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeLocal') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=saludo-app -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqa_c8bd5459e9f6c4c5d84abdc1b823290c29585cd7'
                }
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
