#java_library(
#    name = "tests",
#    srcs = glob(["*.java"]),
#    deps = [
#        "//main/java/slugchat/mobile/service/dao",
#        "//main/java/slugchat/mobile/service/domain",
#        "//main/java/slugchat/mobile/service/implementation",
#        "//main/java/slugchat/mobile/service/mapper",
#        "@com_google_inject_extensions_guice_servlet//jar",
#        "@com_google_inject_guice//jar",
#        "@javax_inject_javax_inject//jar",
#        "@junit_junit//jar",
#        "@org_mybatis_mybatis//jar",
#        "@org_mybatis_mybatis_guice//jar",
#    ],
#)

java_test(
    name = "MobileServiceTest",
    srcs = glob(["*.java"]),
    test_class = "test.java.slugchat.mybatis.impl.MobileServiceTest",
    deps = [
        "//main/java/slugchat/mybatis",
        "//main/java/slugchat/mybatis/domain:domain",
        "//main/java/slugchat/mobile/service/implementation",
        "//main/java/slugchat/mybatis/mapper:mapper",
        "//main/java/slugchat/mybatis/impl",
        "@aopalliance_aopalliance//jar",
        "@com_google_guava_guava//jar",
        "@com_google_inject_extensions_guice_servlet//jar",
        "@com_google_inject_guice//jar",
        "@javax_inject_javax_inject//jar",
        "@junit_junit//jar",
        "@mysql_mysql_connector_java//jar",
        "@org_hsqldb_hsqldb//jar",
        "@org_mybatis_mybatis//jar",
        "@org_mybatis_mybatis_guice//jar",
    ],
)
