pipeline{
    agent any
    environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    }
    stages{
        stage('Build') {
            steps {
                sh 'rm -rf *.jar'
                sh 'mvn clean package'
                sh 'docker build -t shikhara1997/hw3pringboot:latest .'
            }
        }
        stage('Login') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage("Push image to docker hub"){
            steps {
                sh 'docker push shikhara1997/hw3pringboot:latest'
            }
        }
        stage("Deploying on k8") {
            steps{
                sh 'kubectl set image deployment/gkenew container-0=shikhara1997/hw3pringboot:latest -n default'
                sh 'kubectl rollout restart deploy gkenew -n default'
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}
