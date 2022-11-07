pipeline {
    agent any
// environment {
       // DOCKERHUB_CREDENTIALS = credentials('tokendokcerhub')
   // }
    stages {
       stage("git"){
            steps {
                git branch: 'achref',
                url: 'https://github.com/hassanhochlef/AchatProject.git'
         
            }
        }
        // stage('Running Sonar & Nexus services') {
          //   steps {
             //  sh 'docker-compose up -d'
             //   sh 'sleep 60'
               
          //  }
            
      //  }
        
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
      
        
     stage ('Nexus') {
            steps {
                    script {
                        pom = readMavenPom file: "pom.xml";
                        filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                        artifactPath = filesByGlob[0].path;
                        //artifactExists = filesExists artifactPath;
                        //if(artifactExists){
                            nexusArtifactUploader(
                                nexusVersion: 'nexus3',
                                protocol: 'http',
                                nexusUrl: 'http://172.20.10.3:8081/',
                                groupId: 'pom.tn.esprit.rh',
                                version: 'pom.1.0',
                                repository: 'Achat-repository',
                                credentialsId: 'NEXUS_CRED',
                                artifacts: [
                                    [artifactId: 'pom.achat',
                                     classifier: '',
                                     file: artifactPath,
                                     type: pom.packaging
                                        ],
                                        [artifactId: 'pom.achat',
                                     classifier: '',
                                     file: "pom.xml",
                                     type: "pom"
                                        ]
                                    ]
                                
                                );
                       // }
                        //else {
                         //   echo "ok"
                       // }stage("Nexus & Sonar services") {
           
                }
            }
        }
        
       
       
    }
    
}
