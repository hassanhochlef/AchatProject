pipeline {
    agent any
 environment {
        DOCKERHUB_CREDENTIALS = credentials('tockendockerhub')
     DOCKERHUB_CREDENTIALS_USR = "achrefbenhadjyahia"
        DOCKERHUB_CREDENTIALS_PSW  = "A53b335809*"
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
        
        
      stage('push docker hub') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                 sh 'docker push docker.io/achrefbenhadjyahia/achraftest'
   
            }
        }
        
     
        
       
       
    }
    
}
