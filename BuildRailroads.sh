#!/bin/bash

readonly CLASS_PATH="out/src"
readonly SOURCES=$(find -path "./src/*" -name "*.java")

rm -rf ./$CLASS_PATH/*

mkdir -p $CLASS_PATH

javac -d $CLASS_PATH -cp $CLASS_PATH ${SOURCES}

echo Application build into $CLASS_PATH
