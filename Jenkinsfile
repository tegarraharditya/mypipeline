#!/usr/bin/env groovy

node("Node-1") {
 
     stage("Preparing Repositories"){
        checkout scm
     }

     stage("Preparing Environment"){
       dir("$WORKSPACE/BuildingEnvPlaybook"){
          sh('ansible-playbook docker-env.yml -i inventories/develop')
          sh('ansible-playbook docker-service.yml -i inventories/develop') 
          sh('allure')
       }
     }
        
     stage("Unit and Coverage Test"){ 
        sh('gradle -v')
        dir("$WORKSPACE/projects/languages/java/gradle/java-gradle-simple"){
           sh 'gradle wrapper --gradle-version 2.10'
           sh './gradlew sonarqube'
        }
     }

     stage("Functional Test"){
        dir ("$WORKSPACE"){
          sh ('xvfb-run -a testcafe chrome test.js -r xunit > reports/report_test.xml')
          sh ('junit-viewer --results=reports/ --save=reports/report_test.html')
        }
     }

     stage("Run Service"){
        echo 'Push to Node-1 instances'
        echo 'Archive to Current Dir'
        archiveArtifacts artifacts: "**/projects/**", fingerprint: true
        publishHTML (target: [
                          allowMissing: false,
                          alwaysLinkToLastBuild: false,
                          keepAll: true,
                          reportDir: "$WORKSPACE/projects/languages/java/gradle/java-gradle-simple/build/reports/tests",
                          reportFiles: 'index.html',
                          reportName: "Unit-Test-Report"
                     ]
        )
        publishHTML (target: [
                          allowMissing: false,
                          alwaysLinkToLastBuild: false,
                          keepAll: true,
                          reportDir: "$WORKSPACE/reports",
                          reportFiles: 'report_test.html',
                          reportName: 'Functional-Test-Report'
                     ]
        )
        
        step([$class: 'XUnitBuilder',
                thresholds: [[$class: 'FailedThreshold', unstableThreshold: '1']],
                tools: [[$class: 'JUnitType', pattern: 'reports/**']]])
     }

}
