package(
  default_visibility = ["//visibility:public"],
)

java_library(
    name = "producer",
    srcs = glob(["*.java"]),
    deps = [
        "//slugchat/protos:mobile_java_proto",
        "@joda_time_joda_time//jar",
            "//main/java/slugchat/mybatis",
            "//main/java/slugchat/mybatis/impl",
          "//main/java/slugchat/api/annotations",
          "//main/java/slugchat/api/models",
          "//main/java/slugchat/mybatis/domain",
          "//main/java/slugchat/mybatis/dao",
          "//third_party:com_google_inject_guice",
          "//third_party:com_google_guava_guava",
          "//main/java/slugchat/constants",
            "@com_fasterxml_jackson_core_jackson_core//jar",
            "@com_fasterxml_jackson_core_jackson_databind//jar"
    ]
)