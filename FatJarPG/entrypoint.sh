#!/bin/bash
echo "JAVA COMMAND: java $JAVA_ARGS -XX:MaxRAMFraction=1 -jar /app.jar"
java $JAVA_ARGS -XX:MaxRAMFraction=1 -jar /app.jar