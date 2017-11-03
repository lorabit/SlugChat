java_library(
    name = "service",
    srcs = glob(["*.java"]),
    deps = [
        "@com_google_inject_guice//jar", 
        "@com_google_inject_extensions_guice_servlet//jar", 
        "@io_grpc_grpc_core//jar",
        "@io_grpc_grpc_stub//jar",
        "@io_grpc_grpc_protobuf//jar",
        "@com_google_api_grpc_proto_google_common_protos//jar",
        "@com_google_code_findbugs_jsr305//jar",
        "@com_google_guava_guava//jar",
        "@com_google_protobuf_protobuf_java//jar",
        "//slugchat/protos:mobile_java_proto",
    ]
)


java_binary(
    name = "bin",
    runtime_deps = [":service"],
    main_class = "main.java.slugchat.mobile.service.Main",
)