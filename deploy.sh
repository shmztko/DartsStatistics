#!/bin/sh
echo 'deploy start'
home_dir=`pwd`
build_dest=target
project_name=dartsstat

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
if [ $? = 1 ]
then
  exit
fi

echo 'create deploy dir'
deploy_dest=$build_dest/$project_name
mkdir -p $deploy_dest/lib

echo 'copy dependencies'
cp ./target/dependency/* $deploy_dest/lib
cp ./target/dartsstats-*.jar $deploy_dest
cp ./src/main/bin/dartsstat.sh $deploy_dest

echo 'archive package'
cd $build_dest
tar cf - $project_name | gzip > $project_name.tar.gz
cp $project_name.tar.gz $build_dest
cd $home_dir

echo 'delete unused dir'
rm -rf $deploy_dest

echo 'deply end'
