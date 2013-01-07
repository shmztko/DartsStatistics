#!/bin/sh
echo 'deploy start'

deploy_root=./target/dartsstat

echo 'maven build start'
phase=$1
# Proxy環境でテストするときは
# mvn clean install -P test -Dhttp.proxyHost=xxx.xxx.xxx.xxx -Dhttp.proxyPort=nnnn
if [ "$phase" = "" ]
then
	mvn clean install -P test
else
	mvn clean install -P $phase
fi

echo 'create deploy dir'
mkdir -p $deploy_root/lib

echo 'copy dependencies'
cp ./target/dependency/* $deploy_root/lib
cp ./target/dartsstats-*.jar $deploy_root
cp ./src/main/bin/dartsstat.sh $deploy_root

echo 'archive package'
tar cf - $deploy_root | gzip > $deploy_root.tar.gz

echo 'delete unused dir'
rm -rf $deploy_root

echo 'deply end'
