#!/usr/bin/env bash
find . -name "*.java" > sources.txt
javac --release 7 -sourcepath . @sources.txt
java -classpath ./src za.co.julianwolf.Simulator scenario.txt