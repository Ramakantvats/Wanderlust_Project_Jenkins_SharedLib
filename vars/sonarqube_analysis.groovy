def call(String SonarQubeAPI, String Projectname, String ProjectKey){
  withSonarQubeEnv("${SonarQubeAPI}"){     
      sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X" //Executing shell cmd on master node linux terminal. $SONAR_HOME:/opt/sonar-scanner  this cmd becomes /opt/sonar-scanner/bin/sonar-scanner and This is the actual program that scans your source code. -x= shows all the details on terminal  for example: loading pluggins... , connecting to sonar-qube server...
  }  //Projectname: wanderlust (project name is just to show in sonarqube server dash., ProjectKey: wanderlust (Project Key is Unique identifier used internally by SonarQube)
}
// in SonarQubeAPI means : "Use the SonarQube server configuration stored in jenkins ->settings -> system named "Sonar"  and this contains sonarqube server URL,TOKEN so that sonar-scanner tool can connect to the server to send reports of bugs and vulneurabilites.
//conclusion:
//1. Connect to the configured SonarQube server
              ↓
//2. Run sonar-scanner on your source code
              ↓
//3. Upload analysis results to SonarQube server. And sonarqube dashboard shows total bugs, vulneurabilities.

//Note: HOw sonar-scanner will find the code to scan?
//As in starting jenkins stages we will clone the code in current workspace. So it will scan the current workspace code.
