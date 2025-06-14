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
                    sh '''
                        mvn sonar:sonar \
                        -Dsonar.projectKey=saludo-app \
                        -Dsonar.host.url=http://35.171.234.181:9000 \
                        -Dsonar.token=squ_eb4563b34bc4a1ad517b73f66693ba7ba59ad827
                    '''
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
