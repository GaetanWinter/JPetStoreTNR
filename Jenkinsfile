pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
            	echo 'Build des sources JPetStore'
                build job 'JPetStore_Build' 
            }
        }
         stage('Deploy') { 
            steps {
                build job: 'JPetstore_Deploy'
            }
        }
        stage('Qualimetrie') { 
            steps {
                build job: 'JPetStore_SonarQube', parameters: [string(name: 'Browser', value: 'chrome')]
            }
        }
        stage('TNT') { 
            steps {                
                build job: 'JPetStore_Test'
            }
        }
    }
}