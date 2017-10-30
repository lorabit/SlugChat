load("//:generate_workspace.bzl", "generated_maven_jars")
generated_maven_jars()

### proto_library rules implicitly depend on @com_google_protobuf//:protoc,
### which is the proto-compiler.
### This statement defines the @com_google_protobuf repo.
##http_archive(
##    name = "com_google_protobuf",
##    urls = ["https://github.com/google/protobuf/archive/b4b0e304be5a68de3d0ee1af9b286f958750f5e4.zip"],
##    strip_prefix = "protobuf-b4b0e304be5a68de3d0ee1af9b286f958750f5e4",
##    sha256 = "ff771a662fb6bd4d3cc209bcccedef3e93980a49f71df1e987f6afa3bcdcba3a",
##)
#
## java_proto_library rules implicitly depend on @com_google_protobuf_java//:java_toolchain,
## which is the Java proto runtime (base classes and common utilities).
#http_archive(
#    name = "com_google_protobuf_java",
#    urls = ["https://github.com/google/protobuf/archive/b4b0e304be5a68de3d0ee1af9b286f958750f5e4.zip"],
#    strip_prefix = "protobuf-b4b0e304be5a68de3d0ee1af9b286f958750f5e4",
#    sha256 = "ff771a662fb6bd4d3cc209bcccedef3e93980a49f71df1e987f6afa3bcdcba3a",
#)
#
## java_lite_proto_library rules implicitly depend on @com_google_protobuf_javalite//:javalite_toolchain,
## which is the JavaLite proto runtime (base classes and common utilities).
#http_archive(
#    name = "com_google_protobuf_javalite",
#    urls = ["https://github.com/google/protobuf/archive/82809aaebf24fca3c2d5611149c78a3625bd3b70.zip"],
#    strip_prefix = "protobuf-82809aaebf24fca3c2d5611149c78a3625bd3b70",
#    sha256 = "75105f312cefd8aa5e0bdf29279dc8ef0a6f862362b321d35b1ed5c08ce2ecfb",
#)
#
#maven_jar(
#    name = "com_google_inject_guice",
#    artifact = "com.google.inject:guice:3.0",
#)
#
#maven_jar(
#    name = "com_google_inject_extensions",
#    artifact = "com.google.inject.extensions:guice-servlet:3.0",
#)
#
#maven_jar(
#    name = "io_grpc_core",
#    artifact = "io.grpc:grpc-core:1.6.1",
#)
#
#
#maven_jar(
#    name = "io_grpc_stub",
#    artifact = "io.grpc:grpc-stub:1.6.1",
#)
#
#maven_jar(
#    name = "io_grpc_protobuf",
#    artifact = "io.grpc:grpc-protobuf:1.6.1",
#)
#
#maven_jar(
#    name = "guava",
#    artifact = "com.google.guava:guava:18.0",
#)
#
#git_repository(
#  name = "org_pubref_rules_protobuf",
#  remote = "https://github.com/pubref/rules_protobuf",
#  tag = "v0.8.1",
#)
#
#load("@org_pubref_rules_protobuf//java:rules.bzl", "java_proto_repositories")
#java_proto_repositories()
#
#maven_jar(
#    name = "junit4",
#    artifact = "junit:junit:4.12"
#)
#
#maven_jar(
#    name = "org_springframework_core",
#    artifact = "org.springframework:spring-core:5.0.0.RELEASE"
#)
#
#maven_jar(
#    name = "org_springframework_web",
#    artifact = "org.springframework:spring-web:5.0.0.RELEASE"
#)
#maven_jar(
#    name = "org_springframework_aop",
#    artifact = "org.springframework:spring-aop:5.0.0.RELEASE"
#)
#maven_jar(
#    name = "org_springframework_expression",
#    artifact = "org.springframework:spring-expression:5.0.0.RELEASE"
#)
#maven_jar(
#    name = "org_springframework_context",
#    artifact = "org.springframework:spring-context:5.0.0.RELEASE"
#)
#
#maven_jar(
#    name = "org_springframework_beans",
#    artifact = "org.springframework:spring-beans:5.0.0.RELEASE"
#)
#
#maven_jar(
#    name = "org_springframework_boot",
#    artifact = "org.springframework.boot:spring-boot:1.5.7.RELEASE"
#)
#
#maven_jar(
#    name = "org_springframework_boot_autoconfigure",
#    artifact = "org.springframework.boot:spring-boot-autoconfigure:1.5.7.RELEASE"
#)
#
#
#maven_jar(
#    name = "org_springframework_boot_starter",
#    artifact = "org.springframework.boot:spring-boot-starter:1.5.7.RELEASE"
#)
#
#
#maven_jar(
#    name = "org_springframework_boot_starter_web",
#    artifact = "org.springframework.boot:spring-boot-starter-web:1.5.7.RELEASE"
#)
#
#maven_jar(
#    name = "org_springframework_boot_starter_tomcat",
#    artifact = "org.springframework.boot:spring-boot-starter-tomcat:1.5.7.RELEASE",
#)
#
#
#maven_jar(
#    name = "org_springframework_boot_starter_actuator",
#    artifact = "org.springframework.boot:spring-boot-starter-actuator:1.5.7.RELEASE",
#)
#
#maven_jar(
#    name = "org_springframework_boot_starter_security",
#    artifact = "org.springframework.boot:spring-boot-starter-security:1.5.7.RELEASE",
#)
#
#maven_jar(
#    name = "org_springframework_boot_actuator",
#    artifact = "org.springframework.boot:spring-boot-actuator:1.5.7.RELEASE",
#)
#
#
#
#maven_jar(
#    name = "org_apache_commons_logging",
#    artifact = "commons-logging:commons-logging:1.2"
#)
#
#
#maven_jar(
#    name = "javax_servlet",
#    artifact = "javax.servlet:javax.servlet-api:3.1.0"
#)
#
#maven_jar(
#    name = "org_apache_tomcat_embed_jasper",
#    artifact = "org.apache.tomcat.embed:tomcat-embed-jasper:8.5.21"
#)
#maven_jar(
#    name = "org_apache_tomcat_embed_core",
#    artifact = "org.apache.tomcat.embed:tomcat-embed-core:8.5.21"
#)
#
#
#maven_jar(
#    name = "org_apache_tomcat_catalina",
#    artifact = "org.apache.tomcat:tomcat-catalina:8.5.21"
#)
#
#maven_jar(
#    name = "com_fasterxml_jackson",
#    artifact = "com.fasterxml.jackson.core:jackson-core:2.9.1"
#)
#
#
#
#maven_jar(
#    name = "com_fasterxml_jackson_databind",
#    artifact = "com.fasterxml.jackson.core:jackson-databind:2.9.1"
#)
#
#
#maven_jar(
#    name = "com_fasterxml_jackson_annotations",
#    artifact = "com.fasterxml.jackson.core:jackson-annotations:2.9.1"
#)
#
#
#
