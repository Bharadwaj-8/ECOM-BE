pipeline {
    agent any
    environment {
        // Avoid storing sensitive credentials directly in the script
        // Use AWS Credential plugin or Secrets Management plugin for secure storage
        // AWS_ACCOUNT_ID = '...' (remove from environment)
        // AWS_ACCESS_KEY_ID = '...' (remove from environment)
        // AWS_SECRET_ACCESS_KEY = '...' (remove from environment)
        AWS_DEFAULT_REGION = 'ap-south-1'
        IMAGE_REPO_NAME = 'jenkins-pipeline'
        IMAGE_TAG = 'v1'
        REPOSITORY_URI = "${env.REPOSITORY_URI}"
        AWS_ACCESS_KEY_ID = "${env.AWS_Access_Keys}"
        AWS_SECRET_ACCESS_KEY = "${env.AWS_Access_Keys}"
    }

    
   
    stages {
        
         stage('Logging into AWS ECR') {
            steps {
                script {
                sh "${env.Logging_into_ECR}"
                }
                 
            }
        }
        
        stage('Cloning Git') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/staging']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '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', url: 'https://github.com/Bharadwaj-8/ECOM-BE.git']]])     
            }
        }
  
    // Building Docker images
    stage('Building image') {
      steps{
        script {
          sh 'mvn clean install'    
          sh 'docker build -t testing .'
         
        }
      }
    }
   
    // Uploading Docker images into AWS ECR
    stage('Pushing to ECR') {
     steps{  
         script {
                sh """docker tag testing:latest public.ecr.aws/q3j7b1e0/testing:latest"""
                sh """docker push public.ecr.aws/q3j7b1e0/testing:latest"""
         }
        }
      }
    }
}
