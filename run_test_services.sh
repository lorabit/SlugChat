mkdir ~/slugchat

kill `cat ~/slugchat/mobile.pid`
kill `cat ~/slugchat/api.pid`

git pull origin release

bazel build main/java/slugchat/mobile/service:bin
bazel-bin/main/java/slugchat/mobile/service/bin \
  --port 50051 \
  --log /tmp/slugchat.log \
  --db.url "jdbc:mysql://slugchat-test.cqpr0kxypucj.us-west-2.rds.amazonaws.com/slugchat?user=root&password=password&useUnicode=yes&characterEncoding=UTF-8" \
  --dialogflow.apikey 360f730cc1034b19864a1cae700ff632 \
  >> ~/slugchat/mobile.out 2>>~/slugchat/mobile.err \
  &
echo $! > ~/slugchat/mobile.pid

bazel build main/java/slugchat/api:bin
bazel-bin/main/java/slugchat/api/bin \
  --server.port=8080 \
  >> ~/slugchat/api.out 2>>~/slugchat/api.err \
  &
echo $! > ~/slugchat/api.pid