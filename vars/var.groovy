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
           def git = new git2()
           git.Checkout("${config.GIT_URL}","${config.BRANCH_NAME}")
          

    }
    stage ( 'building code') {
      def mvn_exe = new Sample()
          mvn_exe.CleanPackage()
          mvn_exe.GetVersion()

}
}
