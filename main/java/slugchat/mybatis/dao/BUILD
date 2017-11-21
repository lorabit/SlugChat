package(
    default_visibility = ["//visibility:public"],
)

java_library(
    name = "dao",
    srcs = glob(["*.java"]),
    deps = [
        "//main/java/slugchat/mybatis/domain:domain",
        "//main/java/slugchat/mybatis/mapper:mapper",
        "@com_google_guava_guava//jar",
        "@com_google_inject_guice//jar",
        "@org_mybatis_mybatis//jar",
        "@org_mybatis_mybatis_guice//jar",
    ],
)
