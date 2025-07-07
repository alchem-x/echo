#!/bin/sh
cd "$(dirname "$0")" || exit 1

./gradlew clean build -x test --no-daemon
