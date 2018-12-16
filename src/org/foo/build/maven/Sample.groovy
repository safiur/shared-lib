#!/usr/bin/groovy
package org.foo.build.maven
def CleanPackage(String GOAL1, String GOAL2, String GOAL3) {
   mvn_build = sh(returnStdout: true, script: "mvn ${GOAL1} ${GOAL2} ${GOAL3}") 
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
