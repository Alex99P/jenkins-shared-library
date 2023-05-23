#!/usr/bin/env groovy

// we call in Jenkinsfile the name of this file "buildImage"
def call() {
    echo "building the application for branch $BRANCH_NAME"
    sh 'mvn package'
}
