node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/NATSport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/NATSport.git'), string(name: 'PORT_DESCRIPTION', value: 'NATS is a simple, secure and performant communications system for digital systems, services and devices.' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
