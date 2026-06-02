def call(){
  timeout(time: 1, unit: "MINUTES"){            // it means jenkins will wait for 1 minute so that quality gate result can be prepared
      waitForQualityGate abortPipeline: false  // jenkins will ask the sonarqube that qualitygate is passed or not. abortPipeline:false means even if the quality gate is failed still don't stop the pipeline it will work continuously but if we set true so it mean if piepline fails so further stages will stop
  }
}

// Quality gates in sonarqube are some predefined rules which the project code must pass during the anaylysis.
// Test Coverage > 80%
// No Critical Vulnerabilities
// No Blocker Bugs

// If the code violates these rules: Then, Jenkins will stop the deployment.

// The flow is actually:
// Jenkins
//    ↓
// Sonar Scanner analyzes code
//    ↓
// Report uploaded to SonarQube Server
//    ↓
// SonarQube processes report
//    ↓
// Dashboard updated
//    ↓
// Quality Gate evaluated
//    ↓
// Result sent back to Jenkins
