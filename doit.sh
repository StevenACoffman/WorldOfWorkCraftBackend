#!/bin/bash
mvn clean install

echo ************************** COPYING FILES *********************
cp target/worldofworkcraft-0.0.1-SNAPSHOT.war /usr/local/opt/tomcat/libexec/webapps/worldofworkcraft.war
