#!/usr/bin/env groovy

def call() {
echo 'incrementing app version...'
sh 'mvn build-helper:parse-version versions:set \
    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
    versions:commit'
def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
def version = matcher[0][1]
env.IMAGE_NAME = "alexpatroi/demo-app:$version-$BUILD_NUMBER"
}