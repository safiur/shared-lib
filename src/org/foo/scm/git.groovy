#!/usr/bin/groovy
package org.foo.scm
def getSCMInformation() {
        def gitRemoteUrl = steps.sh(script: 'git config --get remote.origin.url').trim()
        def gitCommitSha = steps.sh(script: 'git rev-parse HEAD').trim()
        def gitBranchName = steps.sh(returnStdout: true, script: 'git name-rev --always --name-only HEAD').trim().replace('remotes/origin/', '')

        return [
                url: gitRemoteUrl,
                branch: gitBranchName,
                commit: gitCommitSha
        ]
    }

