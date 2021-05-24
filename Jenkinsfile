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
            		bat "mvn -version"      
                    bat "mvn clean install"                                    
            }
        }
    stage('Build') {
    
      steps {
        bat 'docker build -t debdutta8/docker-spring-boot:2.0.0 .'
      }
    }
    stage('Login') {
      steps {
        bat "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
      }
    }
    stage('Push') {
      steps {
        bat 'docker push debdutta8/docker-spring-boot:2.0.0'
      }
    }
  }
  post {
    always {
      bat 'docker logout'
    }
  }
}