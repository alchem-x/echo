#!/bin/sh
cd "$(dirname "$0")" || exit 1

if [ -f .env ]; then
    . .env
fi

if [ "$PRE_BUILD" = "true" ]; then
  ./build.sh
fi

exec java -Xms64m -Xmx64m -jar build/libs/echo.jar "$@"
