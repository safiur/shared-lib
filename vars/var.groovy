#!/bin/usr/groovy
import org.foo.scm.*
import org.foo.scm.Git.*
import org.foo.build.maven.*

def call(body)
{
   def config = [:]
   body.resolveStrategy = Closure.DELEGATE_FIRST
   body.delegate = config
   body()
       stage ('\u2776 Code Checkout') {
           def git = new git()
           git.Checkout("${config.GIT_URL}","${config.BRANCH_NAME}")
          

    }
    stage ( 'building code') {
      def mvn_exe = new Sample()
          mvn_exe.CleanPackage("${config.GOAL1}","${config.GOAL2}","${config.GOAL3}")
          g_v = mvn_exe.GetVersion()
          G_R = mvn_exe.getSCMInformation().gitRemoteUrl
          println(G_R)
          println(g_v)
          
}
}
