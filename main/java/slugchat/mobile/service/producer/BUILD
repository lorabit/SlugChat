package(
    default_visibility = ["//visibility:public"],
)

java_library(
    name = "producer",
    srcs = glob(["*.java"]),
    deps = [
        "//main/java/slugchat/mobile/service/domain",
        "//main/java/slugchat/mobile/service/implementation",
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
        "@joda_time_joda_time//jar",
    ],
)
