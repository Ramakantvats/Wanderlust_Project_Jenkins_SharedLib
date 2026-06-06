// def call(){
//   dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP' // --Scan:: means  perform scan for current code directory. odcInstallation:OWASP :: means scanning by using the OWASP dependency check tool and tool name is "OWASP". 
//   dependencyCheckPublisher pattern: '**/dependency-check-report.xml' //"Find the OWASP report and show it in the Jenkins dashboard". Explanation: This line means that if any vulneurability founds in any library or version so a dependency-check-report.xml file will be created which shows the severity of the vulneurability so this line finds that report and shows on jenkins.  
// }

def call(){
    catchError(buildResult: 'SUCCESS', stageResult: 'UNSTABLE') {
        dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
    }
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
