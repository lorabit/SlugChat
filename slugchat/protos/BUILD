load("@org_pubref_rules_protobuf//java:rules.bzl", "java_proto_library")

package(
  default_visibility = ["//visibility:public"],
)

proto_library(
    name = "mobile_proto",
    srcs = ["mobile.proto"],
)

java_proto_library(
    name = "mobile_java_proto", 
    protos = ["mobile.proto"],
    with_grpc = True,
)