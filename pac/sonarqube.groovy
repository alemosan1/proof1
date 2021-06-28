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
                        ${SCANNERHOME}/bin/sonar-scanner \
                            -Dsonar.projectKey=Evolved5g \
                            -Dsonar.projectBaseDir=/home/ams@hi.inet/redes_uds \
                            -Dsonar.host.url=http://10.95.133.49 \
                            -Dsonar.login=74d6707285b5c1c79f99b71ca4337e6fd5c31cd8
                    '''
                }
            }
        }
    }
