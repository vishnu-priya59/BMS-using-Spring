#!/bin/bash

echo "Stopping Docker Compose services..."
docker-compose down

echo "Stopping Colima..."
colima stop

echo "Colima and Docker servicstaes stopped."