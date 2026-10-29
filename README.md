# Kalymova Zhansaya Student API

Author: Zhansaya Kalymova, group IT2-2312 (IITU)
Status: initial version

Spring Boot CRUD REST API for students with PostgreSQL, Docker Compose and Jenkins CI/CD.

## Endpoints (http://localhost:8085)
- GET    /api/info
- GET    /api/students
- GET    /api/students/{id}
- POST   /api/students
- PUT    /api/students/{id}
- DELETE /api/students/{id}

## Run
    cp .env.example .env
    docker compose up -d --build
