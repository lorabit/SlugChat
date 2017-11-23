git pull origin release

bazel build main/java/slugchat/mobile/service:bin
kill `cat ~/slugchat/mobile.pid`
bazel-bin/main/java/slugchat/mobile/service/bin \
  --port 50051 \
  --log /tmp/slugchat.log \
  --db.url "jdbc:mysql://slugchat-test.cqpr0kxypucj.us-west-2.rds.amazonaws.com/slugchat?user=root&password=password&useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true" \
  --dialogflow.apikey 360f730cc1034b19864a1cae700ff632 \
  >> ~/slugchat/mobile.out 2>>~/slugchat/mobile.err \
  &
echo $! > ~/slugchat/mobile.pid

bazel build main/java/slugchat/api:bin
kill `cat ~/slugchat/api.pid`
bazel-bin/main/java/slugchat/api/bin \
  --server.port=8080 \
  --db.url="jdbc:mysql://slugchat-test.cqpr0kxypucj.us-west-2.rds.amazonaws.com/slugchat?user=root&password=password&useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true" \
  >> ~/slugchat/api.out 2>>~/slugchat/api.err \
  &
echo $! > ~/slugchat/api.pid