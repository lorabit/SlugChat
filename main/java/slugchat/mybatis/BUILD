package(
    default_visibility = ["//visibility:public"],
)

java_library(
    name = "mybatis",
    srcs = glob(["*.java"]),
    deps = [
        "//main/java/slugchat/mybatis/mapper",
        "//main/java/slugchat/mybatis/impl",
        "@com_google_code_findbugs_jsr305//jar",
        "@com_google_guava_guava//jar",
        "@com_google_inject_extensions_guice_servlet//jar",
        "@com_google_inject_guice//jar",
        "@javax_inject_javax_inject//jar",
        "@mysql_mysql_connector_java//jar",
        "@org_hsqldb_hsqldb//jar",
        "@org_mybatis_mybatis//jar",
        "@org_mybatis_mybatis_guice//jar",
        "@log4j_log4j//jar",
        "@org_slf4j_slf4j_api//jar",
        "@com_beust_jcommander//jar",
    ],
)