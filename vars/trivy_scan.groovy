def call(){
  sh "trivy fs ." // trivy: scanning tool , fs: filesystem scan , . : current directory overall: trivy will scan current directory files for any bug or vulneurabilities.
}
