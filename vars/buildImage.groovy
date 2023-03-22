#!/usr/bin/env groovy


def call() {
    echo 'Building the docker image'
    withCredentials([usernamePassword(credentialsId:'docker-hub-repo', passwordVariable: 'PASS',usernameVariable:'USER' )]){
        sh 'docker build -t alexpatroi/my-jenkins:jma-3.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push alexpatroi/my-jenkins:jma-3.1'
    }
}
