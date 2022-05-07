#!/bin/bash

readonly CLASS_PATH="out/src"
readonly TEST_CLASS_PATH="out/test"
readonly TEST_SOURCES=$(find -path "./test/*" -name "*.java")
readonly TEST_RESOURCES_PATH="./testresources"

rm -rf ./$TEST_CLASS_PATH/*

mkdir -p $TEST_CLASS_PATH

wget -O ./$TEST_CLASS_PATH/junit-platform-console-standalone.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.2/junit-platform-console-standalone-1.8.2.jar

javac -d $TEST_CLASS_PATH -cp "$CLASS_PATH:TEST_CLASS_PATH:$TEST_CLASS_PATH/junit-platform-console-standalone.jar" $TEST_SOURCES

cp -a $TEST_RESOURCES_PATH/. $TEST_CLASS_PATH

echo Tests build into $CLASS_PATH
