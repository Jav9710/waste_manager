@echo off
mvn clean install -P docker & cd docker-compose & docker-compose up -d


