#!/bin/usr/groovy
import org.foo.scm.*

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
}
