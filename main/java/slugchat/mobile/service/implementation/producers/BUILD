package(
    default_visibility = ["//visibility:public"],
)

java_library(
    name = "producers",
    srcs = glob(["*.java"]),
    deps = [
        "//main/java/slugchat/constants",
        "//main/java/slugchat/mobile/service/implementation/annotations",
        "//main/java/slugchat/mybatis/impl",
        "@com_google_guava_guava//jar",
        "@com_google_inject_guice//jar",
        "@joda_time_joda_time//jar",
        "@ai_api_libai//jar",
        "@log4j_log4j//jar",
        "@org_slf4j_slf4j_api//jar",
        "@javax_inject_javax_inject//jar",
        "@org_jsoup_jsoup//jar",
        "//slugchat/protos:mobile_java_proto",
    ],
)
