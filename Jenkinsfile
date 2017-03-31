node("node-1") {
     stage "Preparing Repositories"{
        checkout scm
     }

     stage "Preparing Environment"{
        sh('ansible-playbook prepare_all.yml -i /etc/ansible/hosts -l node2 -f 1')
     }
        
     stage "Unit and Coverage Test"{
        sh('')
     }

     stage "Functional Test "{
        sh ('xvfb-run -a testcafe chrome test.js -')
     }

}
