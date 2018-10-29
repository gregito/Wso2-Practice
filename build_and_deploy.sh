#!/usr/bin/env bash

mvn clean package

docker-compose -f docker-compose-common.yml up -d