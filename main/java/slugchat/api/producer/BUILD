package(
  default_visibility = ["//visibility:public"],
)

java_library(
    name = "producer",
    srcs = glob(["*.java"]),
    deps = [
            "//main/java/slugchat/mybatis",
            "//main/java/slugchat/mybatis/impl",
          "//main/java/slugchat/api/annotations",
          "//main/java/slugchat/api/models",
          "//main/java/slugchat/mybatis/domain",
          "//main/java/slugchat/mybatis/dao",
          "//third_party:com_google_inject_guice",
          "//third_party:com_google_guava_guava",
          "//main/java/slugchat/constants",
    ]
)