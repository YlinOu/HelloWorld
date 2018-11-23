ps -ef | grep demo | grep -v grep | awk '{print $2}'|xargs --no-run-if-empty kill -9
nohup java -jar /var/lib/jenkins/workspace/test/demo/target/demo-0.0.1-SNAPSHOT.jar >/root/null 2>&1 &