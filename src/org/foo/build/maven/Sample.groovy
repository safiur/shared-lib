#!/usr/bin/groovy
package org.foo.build.maven
def CleanPackage(String G1, String G2) {
   mvn_build = sh(returnStdout: true, script: 'mvn  ${G1} ${G2}') 
   return mvn_build
}
