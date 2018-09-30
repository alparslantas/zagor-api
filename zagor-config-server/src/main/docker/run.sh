


echo "********************************************************"
echo "Waiting for the discovery server"
echo "********************************************************"
while ! `nc -z 127.0.0.1 8761`; do sleep 3; done
echo "*******  Discovery Server has started"



echo "********************************************************"
echo "Starting zagor-config-service "
echo "********************************************************"
java   $MEM_ARGS -Dspring.profiles.active=$PROFILE -jar app.jar

