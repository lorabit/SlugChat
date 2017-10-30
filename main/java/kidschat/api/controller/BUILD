load("//:generate_workspace.bzl", "generated_java_libraries")
generated_java_libraries()


package(
  default_visibility = ["//visibility:public"],
)


java_library(
    name = "controller",
    srcs = glob(["*.java"]),
        deps = [
            "//main/java/kidschat/api/annotations",
            "//third_party:com_google_inject_guice",
            "//third_party:com_google_guava_guava",
            "//third_party:org_springframework_spring_core",
            "//third_party:org_springframework_spring_web",
            "//third_party:org_springframework_boot_spring_boot_autoconfigure",
      ],
)