#!/bin/bash

TEST_CLASS_PATH="out/test"
SRC_CLASS_PATH="out/src"
JUNIT_CONSOLE_PATH="$TEST_CLASS_PATH/junit-platform-console-standalone.jar"

java -jar $JUNIT_CONSOLE_PATH --class-path $TEST_CLASS_PATH:$SRC_CLASS_PATH --scan-class-path
