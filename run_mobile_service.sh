bazel run main/java/slugchat/mobile/service:bin -- \
 --port 50051 \
 --log /tmp/slugchat.log \
 --db.url "jdbc:mysql://slugchat-test.cqpr0kxypucj.us-west-2.rds.amazonaws.com/slugchat?user=root&password=password&useUnicode=yes&characterEncoding=UTF-8" \
 --dialogflow.apikey 360f730cc1034b19864a1cae700ff632
