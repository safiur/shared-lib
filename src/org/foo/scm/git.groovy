/*************************************************************************
**** Description :: this groovy code is used to clone the git code    ****
**** Created By  :: DevOps Team                                       ****
**** Created On  :: 108/12/2018                                        ****
**** version     :: 1.0                                               ****
**************************************************************************/
package org.foo.scm

/*****************************************************
***** function to checkout code from Git repository
******************************************************/
def Checkout(String GIT_URL, String BRANCH)
{
          def BRANCH_NAME = "${env.BRANCH_NAME}"
          if ( BRANCH_NAME != "null" && !BRANCH_NAME.isEmpty() && !BRANCH_NAME.trim().isEmpty())
	      { 
     	     BRANCH=BRANCH_NAME
          }
          println "\u001B[32mINFO => Checking out ${GIT_URL} from branch ${BRANCH}, please wait..."
          checkout([$class: 'GitSCM', branches: [[name: "${BRANCH}"]], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'CloneOption', noTags: false, reference: '', shallow: true, timeout: 30]], submoduleCfg: [], userRemoteConfigs: [[url: "${GIT_URL}"]]])
          env.GIT_BRANCH = "${BRANCH}"
          env.GIT_URL = "${GIT_URL}"
   
}

/*****************************************************
***** function to get commit author
******************************************************/
def getCommitAuthorComplete()
{
      author = sh(returnStdout: true, script: "git --no-pager show -s --format='%an <%ae>' HEAD").trim()
      return author
}
