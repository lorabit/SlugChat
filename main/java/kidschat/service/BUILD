load("@org_pubref_rules_protobuf//java:rules.bzl", "java_proto_library")

package(
  default_visibility = ["//visibility:public"],
)

java_library(
    name = "service",
    srcs = glob(["*.java"]),
    deps = [
        "@com_google_inject_guice//jar", 
        "@com_google_inject_extensions//jar", 
        "@io_grpc_core//jar",
        "@io_grpc_stub//jar",
        "@io_grpc_protobuf//jar",
        ":helloworld_java_proto",
    ]
)

java_binary(
    name = "bin",
    runtime_deps = [":service"],
    main_class = "main.java.kidschat.service.Main",
)

proto_library(
    name = "helloworld_proto",
    srcs = ["helloworld.proto"],
)

java_proto_library(
    name = "helloworld_java_proto", 
    protos = ["helloworld.proto"],
     with_grpc = True,
)