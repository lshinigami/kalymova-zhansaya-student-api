# Kalymova Zhansaya Student API

Author: Zhansaya Kalymova, group IT2-2312 (IITU)
<<<<<<< HEAD
Status: v1.0 release (main branch)
=======
Status: documented by Zhansaya Kalymova (documentation branch)
>>>>>>> feature/kalymova-zhansaya-documentation

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

## Change by Zhansaya Kalymova (feature/kalymova-zhansaya-crud)
Improved UPDATE: PUT /api/students/{id} now checks that the student exists.
Before, a missing id silently created a new record; now the API returns
404 Not Found with a JSON message. GET by id and DELETE also return 404.
