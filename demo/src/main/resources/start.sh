ps -ef | demo | grep -v grep | awk '{print $2}'|xargs --no-run-if-empty kill -9
nohup java -Xms256m -Xmx256m -jar /var/lib/jenkins/workspace/test/demo/target/demo-0.0.1-SNAPSHOT.jar >/root/null 2>&1 &