#!/bin/bash

echo "--- Dang su dung Java version: ---"
java -version

echo "--- Bat dau qua trinh Build va Run Test bang Maven Wrapper ---"
# Thêm -ntp để ẩn các dòng Downloading
./mvnw clean test -ntp