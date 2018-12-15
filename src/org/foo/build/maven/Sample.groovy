#!/usr/bin/groovy
package org.foo.build.maven
def CleanPackage()
   mvn_build = sh(returnStdout: true, script: 'mvn clean package') 
   return mvn_build
