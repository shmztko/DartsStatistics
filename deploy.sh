#!/bin/sh
echo 'deploy start'

echo 'create deploy dir'
mkdir -p dartsstat/lib

echo 'copy dependencies'
cp ./target/dependency/* dartsstat/lib
cp ./target/dartsstats-*.jar dartsstat
cp ./src/main/assembly/dartsstat.sh dartsstat

echo 'archive package'
tar cf - dartsstat | gzip > dartsstat.tar.gz

echo 'delete unused dir'
rm -rf ./dartsstat

echo 'deply end'
