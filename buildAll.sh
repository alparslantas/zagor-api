
echo "*** zagor-discovery-server"

cd zagor-discovery-server
./gradlew clean build docker -x test

cd ..

echo "*** zagor-config-server"
cd zagor-config-server
./gradlew clean build docker -x test

cd ..
