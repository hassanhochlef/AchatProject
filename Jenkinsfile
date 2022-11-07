pipeline {
    agent any
 environment {
        DOCKERHUB_CREDENTIALS = credentials('tockendockerhub')
    }
    stages {
       stage("git"){
            steps {
                git branch: 'achref',
                url: 'https://github.com/hassanhochlef/AchatProject.git'
         
            }
        }
       //  stage('Running Sonar & Nexus services') {
        //     steps {
        //       sh 'docker-compose up '
               
               
      //      }
            
    //    }
        
         stage("Cleaning project") {
            steps {
                sh "./mvnw clean"
            }
        }
        stage("Compiling project") {
            steps {
                sh "./mvnw compile"
            }
        }
        
          stage ('Unit Tests') {
            steps {
              
                sh './mvnw test'
                
            }
        }

      
        
        stage (' SonarQube') {
            steps {
                withSonarQubeEnv(credentialsId: 'tokensonarr', installationName: 'sonarqube') {
                     sh  './mvnw sonar:sonar'
                }
            }
        }
          stage ('Package Artifact Jar') {
            steps {
                sh ('./mvnw clean package -Dmaven.test.skip=true')
            }
        }
      
        
     
        
       
       
    }
    
}
