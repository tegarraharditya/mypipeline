#!/usr/bin/env groovy

node("Node-1") {
     stage("Preparing Repositories"){
        checkout scm
     }

     stage("Preparing Environment"){
        sh('ansible-playbook prepare_all.yml -i /etc/ansible/hosts -l node1 -f 1')
     }
        
     stage("Unit and Coverage Test"){ 
        sh('gradle -v')
        sh '''
           echo 'cd $WORKSPACE/projects/languages/java/gradle/java-gradle-simple'
           echo 'gradle wrapper --gradle-version 2.10'
           echo './gradlew sonarqube'
           '''
     }

     stage("Functional Test"){
        sh ('cd $WORKSPACE')
        sh ('xvfb-run -a testcafe chrome test.js -')
     }

     stage("Deploy Service"){
        echo 'Push to Node-1 instances'
        echo 'Archive to Current Dir'
        sh('')
     }

}
