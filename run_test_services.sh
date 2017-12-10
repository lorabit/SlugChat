git pull origin release

bazel build main/java/slugchat/mobile/service:bin
kill `cat ~/slugchat/mobile.pid`
bazel-bin/main/java/slugchat/mobile/service/bin \
  --port 50051 \
  --log /tmp/slugchat.log \
  --db.url "jdbc:mysql://slugchat-test.cqpr0kxypucj.us-west-2.rds.amazonaws.com/slugchat?user=root&password=SlugChatTest&useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true" \
  --dialogflow.apikey 57d847381d9943de9ec9ac66a08e6a03 \
  >> ~/slugchat/mobile.out 2>>~/slugchat/mobile.err \
  &
echo $! > ~/slugchat/mobile.pid

bazel build main/java/slugchat/api:bin
kill `cat ~/slugchat/api.pid`
bazel-bin/main/java/slugchat/api/bin \
  --server.port=8080 \
  --db.url="jdbc:mysql://slugchat-test.cqpr0kxypucj.us-west-2.rds.amazonaws.com/slugchat?user=root&password=SlugChatTest&useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true" \
  --api.story.url="http://ec2-34-209-145-229.us-west-2.compute.amazonaws.com:3000/get_story" \
  --song.urlPrefix="http://p07vrs9k1.bkt.clouddn.com/song/" \
  >> ~/slugchat/api.out 2>>~/slugchat/api.err \
  &
echo $! > ~/slugchat/api.pid