#!/usr/bin/env bash
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
# java za.co.julianwolf.Simulator scenario.txt