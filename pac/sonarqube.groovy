pipeline {
    agent {
        node {
            label 'evol5-sonarqube'
        }
    }
    options {
        timeout(time: 30, unit: 'MINUTES')
    }
    environment {
        //ARTIFACTORY_CRED=credentials('artifactory_credentials')
        SCANNERHOME = tool 'Sonar Scanner 5';
    }
    stages {

        stage('SonarQube analysis') {
            steps {
                    sh '''
                        sudo ${SCANNERHOME}/bin/sonar-scanner -X \
                            -Dsonar.projectKey=Evolved5g \
                            -Dsonar.projectBaseDir=/home/ams@hi.inet/redes_uds/ \
                            -Dsonar.login=40f1332530d31e2372160616f6a458b82c5e429d \
                            -Dsonar.projectName=Evolved5g-master
                    '''
                }
            }
        }
    }
