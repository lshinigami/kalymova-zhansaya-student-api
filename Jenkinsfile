pipeline {
    agent any

    environment {
        STUDENT_NAME = 'Zhansaya Kalymova'
        IMAGE_NAME   = 'kalymova-zhansaya-student-api'
        IMAGE_TAG    = 'v1.0-kalymova-zhansaya'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Pipeline started by student: ${STUDENT_NAME}"
                checkout scm
                sh 'git log --oneline -3'
            }
        }

        stage('Build') {
            steps {
                echo "Building Spring Boot app for ${STUDENT_NAME}"
                sh 'java -version'
                sh 'chmod +x gradlew'
                sh './gradlew --version --no-daemon'
                sh './gradlew clean build -x test --no-daemon'
            }
        }

        stage('Test') {
            steps {
                echo "Running tests for ${STUDENT_NAME}"
                sh './gradlew test --no-daemon'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                echo "Building image ${IMAGE_NAME}:${IMAGE_TAG}"
                sh 'docker version --format "Docker client {{.Client.Version}} / server {{.Server.Version}}"'
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Verify') {
            steps {
                sh "docker image inspect ${IMAGE_NAME}:${IMAGE_TAG} --format 'Image OK: {{index .RepoTags 0}} | size: {{.Size}} bytes | created: {{.Created}}'"
                sh "docker images ${IMAGE_NAME}"
            }
        }
    }

    post {
        success { echo "SUCCESS: ${IMAGE_NAME}:${IMAGE_TAG} built by ${STUDENT_NAME}" }
        failure { echo "FAILED: pipeline of ${STUDENT_NAME} stopped - check the failed stage above" }
    }
}
