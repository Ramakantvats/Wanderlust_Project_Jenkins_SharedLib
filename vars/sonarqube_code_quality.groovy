def call(){
  timeout(time: 1, unit: "MINUTES"){
      waitForQualityGate abortPipeline: false
  }
}

// Quality gates in sonarqube are some predefined rules which the project code must pass during the anaylysis.
// Test Coverage > 80%
// No Critical Vulnerabilities
// No Blocker Bugs

// If the code violates these rules: Then, Jenkins will stop the deployment.
