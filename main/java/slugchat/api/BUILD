

java_library(
    name = "api",
    srcs = glob(["*.java"]),
    deps = [
        "//main/java/slugchat/api/controller",
        "//third_party:org_springframework_spring_core",
        "//third_party:org_springframework_spring_web",
        "//third_party:org_springframework_boot_spring_boot_autoconfigure",
        "//third_party:org_jboss_logging_jboss_logging",
        "//third_party:org_springframework_boot_spring_boot",
        "//third_party:org_springframework_spring_context",
    ],
)


java_binary(
    name = "bin",
    runtime_deps = [
        ":api",
        "//third_party:org_springframework_boot_spring_boot_starter",
        "//third_party:org_springframework_boot_spring_boot_starter_web",
#        "@org_springframework_boot_starter_tomcat//jar",
#        "@org_springframework_boot_starter_web//jar",
#        "@org_springframework_beans//jar",
#        "@org_apache_tomcat_embed_jasper//jar",
#        "@org_apache_tomcat_embed_core//jar",
#        "@org_apache_tomcat_catalina//jar",
#        "@org_springframework_boot_starter//jar",
#        "@org_springframework_boot_starter_actuator//jar",
#        "@org_springframework_boot_actuator//jar",
#        "@guava//jar",
#        "@com_fasterxml_jackson//jar",
#        "@com_fasterxml_jackson_databind//jar",
#        "@com_fasterxml_jackson_annotations//jar",
#        "@org_springframework_boot_starter_security//jar",
        ],
    main_class = "main.java.slugchat.api.Application",
    args = [
        "--server.port=8080",
#        "--server.contextPath=bin/",
#        "--debug",
        ],
)
