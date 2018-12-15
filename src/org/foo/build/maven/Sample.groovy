#!/usr/bin/groovy
package org.foo.build.maven
def CleanPackage(String G1, String G2) {
   mvn_build = sh(returnStdout: true, script: "mvn  ${G1} ${G2}") 
   return mvn_build
}

def getSCMInformation() {
        def gitRemoteUrl = steps.sh(returnStdout: true, script: 'git config --get remote.origin.url').trim()
        def gitCommitSha = steps.sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
        def gitBranchName = steps.sh(returnStdout: true, script: 'git name-rev --always --name-only HEAD').trim().replace('remotes/origin/', '')

        return [
                url: gitRemoteUrl,
                branch: gitBranchName,
                commit: gitCommitSha
        ]
 }
def GetVersion() {
    pom = readMavenPom file: 'pom.xml'
    return  pom.version
}
