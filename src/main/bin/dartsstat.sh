#!/bin/sh
# /dartsstat.sh AddUser st0098@gmail.com たけを＠紫推し http://card.dartslive.com/t/top.jsp?i=559300205543375&n=2124119876
BASE_DIR=/home/takewo/dartsstat
java -cp $BASE_DIR/dartsstats-0.0.1-SNAPSHOT.jar:$BASE_DIR/lib/* -Dfile.encoding=utf-8 org.shmztko.exec.$1 $2 $3 $4 $5
