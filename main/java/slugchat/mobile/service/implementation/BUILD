package(
    default_visibility = ["//visibility:public"],
)

java_library(
    name = "implementation",
    srcs = glob(["*.java"]),
    deps = [
        "//main/java/slugchat/mobile/service/dao",
        "//main/java/slugchat/mobile/service/domain",
        "//main/java/slugchat/mobile/service/mapper",
        "//slugchat/protos:mobile_java_proto",
        "@com_google_guava_guava//jar",
        "@com_google_inject_extensions_guice_servlet//jar",
        "@com_google_inject_guice//jar",
        "@joda_time_joda_time//jar",
        "@org_mybatis_mybatis//jar",
        "@org_mybatis_mybatis_guice//jar",
        "@ai_api_libai//jar",
        "@log4j_log4j//jar",
        "@org_slf4j_slf4j_api//jar"
    ],
)
