java_library(
    name = "service",
    srcs = glob(["*.java"]),
    deps = [
        "//main/java/slugchat/mobile/service/implementation",
        "//main/java/slugchat/mobile/service/mapper",
        "//slugchat/protos:mobile_java_proto",
        "@com_google_api_grpc_proto_google_common_protos//jar",
        "@com_google_code_findbugs_jsr305//jar",
        "@com_google_guava_guava//jar",
        "@com_google_inject_extensions_guice_servlet//jar",
        "@com_google_inject_guice//jar",
        "@com_google_protobuf_protobuf_java//jar",
        "@io_grpc_grpc_core//jar",
        "@io_grpc_grpc_protobuf//jar",
        "@io_grpc_grpc_stub//jar",
        "@javax_inject_javax_inject//jar",
        "@mysql_mysql_connector_java//jar",
        "@org_hsqldb_hsqldb//jar",
        "@org_mybatis_mybatis//jar",
        "@org_mybatis_mybatis_guice//jar",
    ],
)

java_binary(
    name = "bin",
    main_class = "main.java.slugchat.mobile.service.Main",
    runtime_deps = [
        ":service",
        "@aopalliance_aopalliance//jar",
    ],
)
