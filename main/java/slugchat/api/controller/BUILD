package(
  default_visibility = ["//visibility:public"],
)


java_library(
    name = "controller",
    srcs = glob(["*.java"]),
        deps = [
            "//main/java/slugchat/api/annotations",
            "//main/java/slugchat/api/producer",
            "//third_party:com_google_inject_guice",
            "//third_party:com_google_guava_guava",
            "//third_party:org_springframework_spring_core",
            "//third_party:org_springframework_spring_web",
            "@org_springframework_boot_spring_boot//jar",
            "@org_springframework_spring_beans//jar",
            "@javax_inject_javax_inject//jar",
            "//main/java/slugchat/mybatis",
            "//third_party:org_springframework_boot_spring_boot_autoconfigure",
            "@javax_servlet_javax_servlet_api//jar",
            "//main/java/slugchat/api/models",
            "@org_slf4j_slf4j_api//jar",
            "@com_fasterxml_jackson_core_jackson_core//jar",
            "@com_fasterxml_jackson_core_jackson_databind//jar"
      ],
)