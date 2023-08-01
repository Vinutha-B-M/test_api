# TOMCAT_PATH="/Users/premanand/Public/components/apache-tomcat-8.5.30/";
# SRC_PATH="/Users/premanand/Public/projects/POS_API/";

TOMCAT_PATH="/Library/Tomcat/";
SRC_PATH="/Users/goalsrindia/Projects/Zuna-REST/code/Zunaco-REST/";

echo "building zunaco api....."
cd ..
cd "$SRC_PATH"zuna-api
mvn clean install
echo "#########################################"

echo "removing old build in webapps....."
sudo rm -rf "$TOMCAT_PATH"webapps/zunaco-api/
sudo rm -rf "$TOMCAT_PATH"webapps/zunaco-api.war
echo "#########################################"

echo "deploying Zunaco api....."

cd "$SRC_PATH"zuna-api/target/

ls

cp zunaco-api.war /Library/Tomcat/webapps/

echo "#########################################"

echo "restarting tomcat"
cd "$TOMCAT_PATH"bin
sudo ./catalina.sh run
