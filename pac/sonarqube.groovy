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
                            -Dsonar.projectBaseDir=/home/ams@hi.inet/redes_uds \
                            -Dsonar.host.url=http://10.95.133.49 \
                            -Dsonar.login=8785bc53c0479224e256beeff2f610e5aa157425
                    '''
                }
            }
        }
    }
