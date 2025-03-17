#!/bin/bash

echo "Starting Colima..."
colima start

echo "Starting Docker Compose services..."
docker-compose up -d

echo "Checking running containers..."
docker ps

echo "Elasticsearch & Kibana should be running!"