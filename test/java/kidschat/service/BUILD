java_library(
    name = "tests",
    srcs = glob(["*.java"]),
    deps = [
      "@junit4//jar",
    ],
)

java_test(
    name = "MainTest",
    srcs = glob(["*.java"]),
    deps = [
      "@junit4//jar",
      "//main/java/kidschat/service",
    ],
    test_class = "test.java.kidschat.service.MainTest",
)
#
#java_test(
#    name = "service",
#    srcs = glob(["*.java"]),
#    deps = [
#      "@junit4//jar",
#    ],
#)