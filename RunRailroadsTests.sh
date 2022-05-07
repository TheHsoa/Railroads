#!/bin/bash

readonly TEST_CLASS_PATH="out/test"
readonly SRC_CLASS_PATH="out/src"
readonly JUNIT_CONSOLE_PATH="$TEST_CLASS_PATH/junit-platform-console-standalone.jar"

java -jar $JUNIT_CONSOLE_PATH --class-path $TEST_CLASS_PATH:$SRC_CLASS_PATH --scan-class-path
