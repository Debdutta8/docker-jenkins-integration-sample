pipeline {
  agent { label 'master' }
  tools{
  	maven "3.8.1"
  	}
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  environment {
    DOCKERHUB_CREDENTIALS = credentials('debdutta8-dockerhub')
  }
  stages {
    stage ("Build App") {
            steps {         
            		sh "mvn -version"      
                    sh "mvn clean install"                                    
            }
        }
    stage('Build') {
    
      steps {
        sh 'docker build -t debdutta8/docker-spring-boot:latest .'
      }
    }
    stage('Login') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
      }
    }
    stage('Push') {
      steps {
        sh 'docker push debdutta8/docker-spring-boot:latest'
      }
    }
  }
  post {
    always {
      sh 'docker logout'
    }
  }
}