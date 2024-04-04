#!/usr/bin/env bash

set -e

DOCKER_ENTITY_NAME="waspti"
DOCKER_IMAGE="wasp-avt-api"
#TAGS_AMD64 = | amd64-test-1.0-beta | amd64-dev-1.0-beta | amd64-prod-1.0-beta
#TAGS_ARM64/v8 = | arm64-v8-test-1.0-beta | arm64-v8-dev-1.0-beta | arm64-v8-prod-1.0-beta
DOCKER_IMAGE_TAG=""
FLAG_V="Y"
BUILD_OPTION="0"
ARCH_OPTION="0"
PLATFORM=("linux/amd64", "linux/arm64/v8")
docker_user=""
docker_password=""
isToPush="n"
isNeededToLogin="n"
startContainer="n"

#[arm64-v8-test-1.0, arm64-v8-dev-1.0, arm64-v8-prod-1.0]


echo "*******************************************************************"
echo "*                       Options Available                         *"
echo "*******************************************************************"
read -p "Do you need to delete the container using -v flag? [y/n]: " FLAG_V
echo "=========================Building options=========================="
echo "TEST BUILDING        [0]"
echo "DEVELOPMENT BUILDING [1]"
echo "PRODUCTION BUILDING  [2]"
read -p "Choose a option for build: " BUILD_OPTION
echo "=========================ARCH options=========================="
echo "LINUX/AMD64    [0]"
echo "LINUX/ARM64/V8 [1]"
echo "Build for All Arch [2]"
read -p "Choose a option for build: " ARCH_OPTION
echo "=================================================================="
echo "Using flag -v = [$FLAG_V]"
echo "Option selected for build = [$BUILD_OPTION]"
echo "Option selected for arch = [$ARCH_OPTION]"
echo "=================================================================="
read -p "DOCKER HUB: Do you wanna push to dockerhub after finish the build? [y/n]: " isToPush
echo "You must be authenticated with dockerhub to push after finish the build."
read -p "START: Do you wanna start the container after push is finished? [y/n]: " startContainer
if [[ "$isToPush" = 'y' ]]
then
      read -p "Docker username: " docker_user
      read -sp "Docker password: " docker_password

      REGISTRY_URL="https://index.docker.io/v1/"
      USERNAME="$docker_user"
      PASSWORD="$docker_password"
      docker login $REGISTRY_URL -u $USERNAME -p $PASSWORD
fi

if [[ "$FLAG_V" = 'y' ]];
then
      echo "executing docker-compose down -v"
      docker-compose down -v
else
      echo "executing docker-compose down"
      docker-compose down
fi

echo "RUNNING [CLEAN INSTALL, COMPILE AND PACKAGE]"
mvn clean install -DskipTests && mvn compile -DskipTests && mvn package -DskipTests

# =======================================BUILDING FOR TEST=====================================
if [[ "$BUILD_OPTION" = '0' ]];
then
      if [[ "$ARCH_OPTION" = '0' ]];
      then
            DOCKER_IMAGE_TAG="amd64-test-1.0-beta"
            echo "BUILDING TEST IMAGE [$DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG] FOR [${PLATFORM[$ARCH_OPTION]}]"
            docker buildx build --platform linux/arm64/v8 -t $DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG .
      fi
      if [[ "$ARCH_OPTION" = '1' ]];
      then
            DOCKER_IMAGE_TAG="arm64-v8-test-1.0-beta"
            echo "BUILDING TEST IMAGE [$DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG] FOR [${PLATFORM[$ARCH_OPTION]}]"
            docker buildx build --platform linux/arm64/v8 -t $DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG .
      fi
      if [[ "$ARCH_OPTION" = '2' ]];
      then
            DOCKER_IMAGE_TAG=("amd64-test-1.0-beta" "arm64-v8-test-1.0-beta" )
            index=0
            for  i in ${DOCKER_IMAGE_TAG[@]}
            do
                  echo "BUILDING TEST IMAGE [$DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$i] FOR [${PLATFORM[$index]}]"
                  index = "$index" + 1
#                  docker buildx build --platform linux/arm64/v8 -t $DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG .
            done
      fi
fi
# =======================================BUILDING FOR DEVELOPMENT=====================================
if [[ "$BUILD_OPTION" = '1' ]];
then
      if [[ "$ARCH_OPTION" = '0' ]];
      then
            DOCKER_IMAGE_TAG="amd64-dev-1.0-beta"
            echo "BUILDING DEVELOPMENT IMAGE [$DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG] FOR [${PLATFORM[$ARCH_OPTION]}]"
            docker buildx build --platform linux/arm64/v8 -t $DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG .
      fi
      if [[ "$ARCH_OPTION" = '1' ]];
      then
            DOCKER_IMAGE_TAG="arm64-v8-dev-1.0-beta"
            echo "BUILDING DEVELOPMENT IMAGE [$DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG] FOR [${PLATFORM[$ARCH_OPTION]}]"
            docker buildx build --platform linux/arm64/v8 -t $DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG .
      fi
      if [[ "$ARCH_OPTION" = '2' ]];
      then
            DOCKER_IMAGE_TAG=("amd64-dev-1.0-beta" "arm64-v8-dev-1.0-beta" )
            index=0
            for  i in ${DOCKER_IMAGE_TAG[@]}
            do
                  echo "BUILDING DEVELOPMENT IMAGE [$DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$i] FOR [${PLATFORM[$index]}]"
                  index = "$index" + 1
#                  docker buildx build --platform linux/arm64/v8 -t $DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG .
            done
      fi
fi
# =======================================BUILDING FOR PRODUCTION=====================================

# =======================================FINAL STEP=====================================
if [[ "$isToPush" = 'y' ]]
then
      echo "Pushing the image to the DockerHub Server"
      docker push $DOCKER_ENTITY_NAME/$DOCKER_IMAGE:$DOCKER_IMAGE_TAG
fi
#=============================STARTING CONTAINERS======================================
if [[ "$startContainer" = 'y' ]]
then
      docker-compose up -d --build --force-recreate db mysql-exporter spring angular prometheus grafana smtp
      echo "stopping:"
      docker stop wasp-avt-api

      source .env
      ./wait-until.sh "docker-compose exec -T -e MYSQL_PWD=${MYSQL_ROOT_PWD} -e MYSQL_USER=${MYSQL_USER} db mysql -D ${MYSQL_DATABASE} -e 'select now()'"

      echo "restarting:"
      docker restart wasp-avt-api
fi

#read -p 'Username: ' name
#
#case $1 in
#"--create")
#  echo "Creating new file $2"
#  echo
#  touch $2
#  ;;
#
#"--delete")
#  echo "Deleting file $2"
#  echo
#  rm $2
#  ;;
#
#*)
#echo "Not a valid argument"
#echo
#;;
#esac



#docker-compose down -v
#echo "RUNNING [CLEAN INSTALL, COMPILE AND PACKAGE]"
#mvn clean install -DskipTests && mvn compile -DskipTests && mvn package -DskipTests
#echo "BUILDING TEST IMAGE [$$DOCKER_ENTITY_NAME/$$DOCKER_IMAGE:arm64-v8-dev-1.0] FOR [linux/arm64/v8]"
#echo "BUILDING DEVELOPMENT IMAGE [$$DOCKER_ENTITY_NAME/$$DOCKER_IMAGE:arm64-v8-dev-1.0] FOR [linux/arm64/v8]"
#echo "BUILDING PRODUCTION IMAGE [$$DOCKER_ENTITY_NAME/$$DOCKER_IMAGE:arm64-v8-dev-1.0] FOR [linux/arm64/v8]"
#docker buildx build --platform linux/arm64/v8 -t $$DOCKER_ENTITY_NAME/$$DOCKER_IMAGE:$$DOCKER_IMAGE_TAG .
#./Dockerfile

#
#docker buildx build --platform linux/arm64/v8 -t waspti/wasp-avt-api:amd64-test-1.0-beta .
#
#
#./Dockerfile

#
#Script for Dump MySQL Database ignoring some tables
# mysqldump -u root -p wasp_avt_db --ignore-table=wasp_avt_db.Comprovativo --ignore-table=wasp_avt_db.Proforma --ignore-table=wasp_avt_db.Pedidos --ignore-table=wasp_avt_db.PedidosDetalhe > wasp01-dump.sql

#docker run --rm -it -p 5672:5672 rabbitmq:3.11.0
#docker run -d -p 9411:9411 openzipkin/zipkin