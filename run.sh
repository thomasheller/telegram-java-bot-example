#!/bin/sh
set -e
./gradlew build
java -jar build/libs/telegram-java-bot-example-1.0.0.jar
