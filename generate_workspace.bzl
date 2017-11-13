# The following dependencies were calculated from:
#
# generate_workspace --maven_project=/Users/lorabit/Develop/springboot-rest-api-demo


def generated_maven_jars():

  native.maven_jar(
      name = "org_mybatis_mybatis_guice",
      artifact = "org.mybatis:mybatis-guice:3.10",
  )

  native.maven_jar(
      name = "org_mybatis_mybatis",
      artifact = "org.mybatis:mybatis:3.4.5",
  )
#
#
#  native.maven_jar(
#      name = "io_grpc_grpc_stub",
#      artifact = "io.grpc:grpc-stub:1.6.1",
#  )

#
#  # io.grpc:grpc-core:jar:1.6.1
#  native.maven_jar(
#      name = "io_opencensus_opencensus_api",
#      artifact = "io.opencensus:opencensus-api:0.5.1",
#      sha1 = "cbd0a716a7d85ac34b83d86b13f0a6655e45c2ba",
#  )
#

  # org.sonatype.sisu.inject:cglib:jar:2.2.1-v20090111
  native.maven_jar(
      name = "asm_asm",
      artifact = "asm:asm:3.1",
      sha1 = "c157def142714c544bdea2e6144645702adf7097",
  )

  native.maven_jar(
      name = "com_google_inject_guice",
      artifact = "com.google.inject:guice:4.1.0",
  )


  # com.google.inject:guice:jar:4.1.0
  native.maven_jar(
      name = "javax_inject_javax_inject",
      artifact = "javax.inject:javax.inject:1",
      sha1 = "6975da39a7040257bd51d21a231b76c915872d38",
  )

  # com.google.guava:guava:bundle:23.0
  native.maven_jar(
      name = "org_codehaus_mojo_animal_sniffer_annotations",
      artifact = "org.codehaus.mojo:animal-sniffer-annotations:1.14",
      sha1 = "775b7e22fb10026eed3f86e8dc556dfafe35f2d5",
  )

  # com.google.guava:guava:bundle:23.0
  native.maven_jar(
      name = "com_google_j2objc_j2objc_annotations",
      artifact = "com.google.j2objc:j2objc-annotations:1.1",
      sha1 = "ed28ded51a8b1c6b112568def5f4b455e6809019",
  )

  # org.springframework.boot:spring-boot-starter-logging:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "ch_qos_logback_logback_classic",
      artifact = "ch.qos.logback:logback-classic:1.1.3",
      sha1 = "d90276fff414f06cb375f2057f6778cd63c6082f",
  )


  # org.springframework.boot:spring-boot-starter-tomcat:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_apache_tomcat_embed_tomcat_embed_el",
      artifact = "org.apache.tomcat.embed:tomcat-embed-el:8.0.20",
      sha1 = "8050b326d0ee31ba91b06e420b57efe77a6f0516",
  )


  # org.springframework.boot:spring-boot-starter-test:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_springframework_spring_test",
      artifact = "org.springframework:spring-test:4.1.6.RELEASE",
      sha1 = "89612cafdac51bc92d9bd512e1863a9111a08b4e",
  )


  # org.springframework:spring-aop:jar:4.1.6.RELEASE
  native.maven_jar(
      name = "aopalliance_aopalliance",
      artifact = "aopalliance:aopalliance:1.0",
      sha1 = "0235ba8b489512805ac13a8f9ea77a1ca5ebe3e8",
  )

  # com.google.inject:guice:jar:3.0
  native.maven_jar(
      name = "org_sonatype_sisu_inject_cglib",
      artifact = "org.sonatype.sisu.inject:cglib:2.2.1-v20090111",
      sha1 = "07ce5e983fd0e6c78346f4c9cbfa39d83049dda2",
  )


  # org.springframework.boot:spring-boot:jar:1.2.3.RELEASE
  # org.springframework.data:spring-data-mongodb:jar:1.6.2.RELEASE got requested version
  # org.springframework:spring-web:jar:4.1.6.RELEASE got requested version
  # org.springframework:spring-webmvc:jar:4.1.6.RELEASE got requested version
  native.maven_jar(
      name = "org_springframework_spring_context",
      artifact = "org.springframework:spring-context:4.1.6.RELEASE",
      sha1 = "15f0b22bf89ed468badbc4eec759af2b916d33e4",
  )


  # org.springframework.boot:spring-boot-starter-test:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_mockito_mockito_core",
      artifact = "org.mockito:mockito-core:1.10.19",
      sha1 = "e8546f5bef4e061d8dd73895b4e8f40e3fe6effe",
  )


  # org.springframework:spring-web:jar:4.1.6.RELEASE got requested version
  # org.springframework:spring-context:jar:4.1.6.RELEASE
  native.maven_jar(
      name = "org_springframework_spring_aop",
      artifact = "org.springframework:spring-aop:4.1.6.RELEASE",
      sha1 = "686c13ba57d9423dede9c5d580dcadc5c67a2761",
  )


  # org.springframework.boot:spring-boot-starter-logging:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_slf4j_jul_to_slf4j",
      artifact = "org.slf4j:jul-to-slf4j:1.7.11",
      sha1 = "87a1d59c837c57396bc20f433ee24ad3a59c7812",
  )


  # org.springframework.data:spring-data-mongodb:jar:1.6.2.RELEASE got requested version
  # org.springframework:spring-context:jar:4.1.6.RELEASE
  # org.springframework:spring-webmvc:jar:4.1.6.RELEASE got requested version
  native.maven_jar(
      name = "org_springframework_spring_expression",
      artifact = "org.springframework:spring-expression:4.1.6.RELEASE",
      sha1 = "8bf70887c2c883a6f6e552dbe46eec35c07adf6a",
  )


  # org.springframework.boot:spring-boot-starter-logging:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_slf4j_log4j_over_slf4j",
      artifact = "org.slf4j:log4j-over-slf4j:1.7.11",
      sha1 = "4f51599470151c7b8ebec1d36767138f7fb7d427",
  )


  # org.hibernate:hibernate-validator:jar:5.1.3.Final
  native.maven_jar(
      name = "org_jboss_logging_jboss_logging",
      artifact = "org.jboss.logging:jboss-logging:3.1.3.GA",
      sha1 = "64499e907f19e5e1b3fdc02f81440c1832fe3545",
  )


  # org.springframework.boot:spring-boot-starter:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_springframework_boot_spring_boot_starter_logging",
      artifact = "org.springframework.boot:spring-boot-starter-logging:1.2.3.RELEASE",
      sha1 = "43093c137ea9c6d26ca6341e17295c0a6c506dfb",
  )


  # org.springframework.boot:spring-boot-starter-web:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_hibernate_hibernate_validator",
      artifact = "org.hibernate:hibernate-validator:5.1.3.Final",
      sha1 = "334d46a93cf095160ce06d8382594b904933c808",
  )


  # ch.qos.logback:logback-classic:jar:1.1.3
  native.maven_jar(
      name = "ch_qos_logback_logback_core",
      artifact = "ch.qos.logback:logback-core:1.1.3",
      sha1 = "e3c02049f2dbbc764681b40094ecf0dcbc99b157",
  )


  # org.springframework.boot:spring-boot-autoconfigure:jar:1.2.3.RELEASE got requested version
  # org.springframework.boot:spring-boot-starter:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_springframework_boot_spring_boot",
      artifact = "org.springframework.boot:spring-boot:1.2.3.RELEASE",
      sha1 = "2601c81786dd8d88fd7e53af1a3950ef45fd5507",
  )


  # org.springframework.boot:spring-boot-starter-tomcat:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_apache_tomcat_embed_tomcat_embed_logging_juli",
      artifact = "org.apache.tomcat.embed:tomcat-embed-logging-juli:8.0.20",
      sha1 = "234ee053b3dbd4bca2fc221a99d4f7d292d33e0b",
  )


  # pom.xml got requested version
  # net.javabeat:springboot-rest-demo:jar:0.1
  native.maven_jar(
      name = "org_springframework_boot_spring_boot_starter_test",
      artifact = "org.springframework.boot:spring-boot-starter-test:1.2.3.RELEASE",
      sha1 = "054085e817e590cecc8fce780d5c7b89de81edcc",
  )


  # org.mockito:mockito-core:jar:1.10.19
  native.maven_jar(
      name = "org_objenesis_objenesis",
      artifact = "org.objenesis:objenesis:2.1",
      sha1 = "87c0ea803b69252868d09308b4618f766f135a96",
  )


  # org.springframework.boot:spring-boot-starter-test:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_hamcrest_hamcrest_library",
      artifact = "org.hamcrest:hamcrest-library:1.3",
      sha1 = "4785a3c21320980282f9f33d0d1264a69040538f",
  )


  # org.springframework.boot:spring-boot-starter-web:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_springframework_boot_spring_boot_starter_tomcat",
      artifact = "org.springframework.boot:spring-boot-starter-tomcat:1.2.3.RELEASE",
      sha1 = "32de443f4e43ceee62c3e1e855fee076fec546b3",
  )


  # org.springframework.boot:spring-boot-starter-test:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "junit_junit",
      artifact = "junit:junit:4.12",
      sha1 = "2973d150c0dc1fefe998f834810d68f278ea58ec",
  )


  # org.springframework.data:spring-data-commons:jar:1.9.2.RELEASE wanted version 1.7.10
  # org.slf4j:jul-to-slf4j:jar:1.7.11 got requested version
  # ch.qos.logback:logback-classic:jar:1.1.3 wanted version 1.7.7
  # org.slf4j:log4j-over-slf4j:jar:1.7.11 got requested version
  # org.springframework.data:spring-data-mongodb:jar:1.6.2.RELEASE wanted version 1.7.10
  # org.slf4j:jcl-over-slf4j:jar:1.7.11
  native.maven_jar(
      name = "org_slf4j_slf4j_api",
      artifact = "org.slf4j:slf4j-api:1.7.11",
      sha1 = "007eaaaf2238f324e2b02dbd4d6ced6778b99328",
  )


  # org.hibernate:hibernate-validator:jar:5.1.3.Final
  native.maven_jar(
      name = "javax_validation_validation_api",
      artifact = "javax.validation:validation-api:1.1.0.Final",
      sha1 = "8613ae82954779d518631e05daa73a6a954817d5",
  )


  # org.apache.tomcat.embed:tomcat-embed-websocket:jar:8.0.20 got requested version
  # org.springframework.boot:spring-boot-starter-tomcat:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_apache_tomcat_embed_tomcat_embed_core",
      artifact = "org.apache.tomcat.embed:tomcat-embed-core:8.0.20",
      sha1 = "5810725255089f4d0b7ab19ac70b8c4a9cd8d4a3",
  )


  # org.mockito:mockito-core:jar:1.10.19 wanted version 1.1
  # org.hamcrest:hamcrest-library:jar:1.3 got requested version
  # org.springframework.boot:spring-boot-starter-test:jar:1.2.3.RELEASE got requested version
  # junit:junit:jar:4.12
  native.maven_jar(
      name = "org_hamcrest_hamcrest_core",
      artifact = "org.hamcrest:hamcrest-core:1.3",
      sha1 = "42a25dc3219429f0e5d060061f71acb49bf010a0",
  )


  # org.springframework.data:spring-data-mongodb:jar:1.6.2.RELEASE
  native.maven_jar(
      name = "org_springframework_data_spring_data_commons",
      artifact = "org.springframework.data:spring-data-commons:1.9.2.RELEASE",
      sha1 = "6f92f93d9f837ea8a97a99e9bb850d3a08974c99",
  )


  # org.springframework.boot:spring-boot-starter-data-mongodb:jar:1.2.3.RELEASE got requested version
  # org.springframework.boot:spring-boot-starter-web:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_springframework_boot_spring_boot_starter",
      artifact = "org.springframework.boot:spring-boot-starter:1.2.3.RELEASE",
      sha1 = "a50eea39bce85f09db0fc43d80e86aa767e8cc24",
  )


  # pom.xml got requested version
  # net.javabeat:springboot-rest-demo:jar:0.1
  native.maven_jar(
      name = "org_springframework_boot_spring_boot_starter_data_mongodb",
      artifact = "org.springframework.boot:spring-boot-starter-data-mongodb:1.2.3.RELEASE",
      sha1 = "be988904e4be51590963a7032830719b82146be6",
  )


  # org.springframework.data:spring-data-commons:jar:1.9.2.RELEASE wanted version 1.7.10
  # org.springframework.boot:spring-boot-starter-logging:jar:1.2.3.RELEASE
  # org.springframework.data:spring-data-mongodb:jar:1.6.2.RELEASE wanted version 1.7.10
  native.maven_jar(
      name = "org_slf4j_jcl_over_slf4j",
      artifact = "org.slf4j:jcl-over-slf4j:1.7.11",
      sha1 = "180246b7809ffae6293eea3d34e668ee948f0dc8",
  )


  # org.springframework.boot:spring-boot-starter-data-mongodb:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_springframework_data_spring_data_mongodb",
      artifact = "org.springframework.data:spring-data-mongodb:1.6.2.RELEASE",
      sha1 = "a0292bffe73a65b73fde8420dffcef16c83a7c5e",
  )


  # org.springframework.boot:spring-boot-starter:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_springframework_boot_spring_boot_autoconfigure",
      artifact = "org.springframework.boot:spring-boot-autoconfigure:1.2.3.RELEASE",
      sha1 = "11175f217ac34bdacd6282cd44310f211121e270",
  )


  # com.fasterxml.jackson.core:jackson-databind:bundle:2.4.5
  native.maven_jar(
      name = "com_fasterxml_jackson_core_jackson_annotations",
      artifact = "com.fasterxml.jackson.core:jackson-annotations:2.4.0",
      sha1 = "d6a66c7a5f01cf500377bd669507a08cfeba882a",
  )


  # org.hibernate:hibernate-validator:jar:5.1.3.Final
  native.maven_jar(
      name = "com_fasterxml_classmate",
      artifact = "com.fasterxml:classmate:1.0.0",
      sha1 = "434efef28c81162b17c540e634cffa3bd9b09b4c",
  )


  # pom.xml got requested version
  # net.javabeat:springboot-rest-demo:jar:0.1
  native.maven_jar(
      name = "org_springframework_boot_spring_boot_starter_web",
      artifact = "org.springframework.boot:spring-boot-starter-web:1.2.3.RELEASE",
      sha1 = "d4a2ea5c2dfa465054d9b2675ff7794d8d97f311",
  )


  # org.springframework.boot:spring-boot-starter-web:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "com_fasterxml_jackson_core_jackson_databind",
      artifact = "com.fasterxml.jackson.core:jackson-databind:2.4.5",
      sha1 = "c69c0cb613128c69d84a6a0304ddb9fce82e8242",
  )


  # org.springframework.data:spring-data-mongodb:jar:1.6.2.RELEASE got requested version
  # org.springframework.boot:spring-boot-starter-data-mongodb:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_mongodb_mongo_java_driver",
      artifact = "org.mongodb:mongo-java-driver:2.12.5",
      sha1 = "8e53a39f2a5b2755ecc394d48d18026460f5da58",
  )


  # org.springframework.boot:spring-boot-starter-web:jar:1.2.3.RELEASE
  # org.springframework:spring-webmvc:jar:4.1.6.RELEASE got requested version
  native.maven_jar(
      name = "org_springframework_spring_web",
      artifact = "org.springframework:spring-web:4.1.6.RELEASE",
      sha1 = "960101b25d0ec6f45d550bf92c00de8c6a584e6a",
  )


  # org.springframework:spring-context:jar:4.1.6.RELEASE got requested version
  # org.springframework.data:spring-data-mongodb:jar:1.6.2.RELEASE got requested version
  # org.springframework:spring-web:jar:4.1.6.RELEASE got requested version
  # org.springframework.data:spring-data-commons:jar:1.9.2.RELEASE got requested version
  # org.springframework:spring-aop:jar:4.1.6.RELEASE
  # org.springframework:spring-tx:jar:4.1.6.RELEASE got requested version
  # org.springframework:spring-webmvc:jar:4.1.6.RELEASE got requested version
  native.maven_jar(
      name = "org_springframework_spring_beans",
      artifact = "org.springframework:spring-beans:4.1.6.RELEASE",
      sha1 = "ce2d409d470948f11fad41ffdf37dcff4d28cd7c",
  )


  # org.springframework.boot:spring-boot-starter-tomcat:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_apache_tomcat_embed_tomcat_embed_websocket",
      artifact = "org.apache.tomcat.embed:tomcat-embed-websocket:8.0.20",
      sha1 = "0b4914491d1baa90958e5c951bec7140e65874f3",
  )


  # org.springframework.boot:spring-boot-starter-web:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_springframework_spring_webmvc",
      artifact = "org.springframework:spring-webmvc:4.1.6.RELEASE",
      sha1 = "e1ee19a5359f214d65cc18972df8aba17ce1e423",
  )


  # org.springframework:spring-web:jar:4.1.6.RELEASE got requested version
  # org.springframework.boot:spring-boot-starter-web:jar:1.2.3.RELEASE got requested version
  # org.springframework.boot:spring-boot-starter:jar:1.2.3.RELEASE got requested version
  # org.springframework.data:spring-data-commons:jar:1.9.2.RELEASE got requested version
  # org.springframework:spring-beans:jar:4.1.6.RELEASE got requested version
  # org.springframework:spring-webmvc:jar:4.1.6.RELEASE got requested version
  # org.springframework:spring-context:jar:4.1.6.RELEASE got requested version
  # org.springframework.boot:spring-boot:jar:1.2.3.RELEASE
  # org.springframework.data:spring-data-mongodb:jar:1.6.2.RELEASE got requested version
  # org.springframework:spring-expression:jar:4.1.6.RELEASE got requested version
  # org.springframework.boot:spring-boot-starter-test:jar:1.2.3.RELEASE got requested version
  # org.springframework:spring-aop:jar:4.1.6.RELEASE got requested version
  # org.springframework.boot:spring-boot-starter-data-mongodb:jar:1.2.3.RELEASE got requested version
  # org.springframework:spring-tx:jar:4.1.6.RELEASE got requested version
  # org.springframework:spring-test:jar:4.1.6.RELEASE got requested version
  native.maven_jar(
      name = "org_springframework_spring_core",
      artifact = "org.springframework:spring-core:4.1.6.RELEASE",
      sha1 = "e2f486124d5dea2d91a9c2ea7d4456bc343ca2cc",
  )


  # com.fasterxml.jackson.core:jackson-databind:bundle:2.4.5
  native.maven_jar(
      name = "com_fasterxml_jackson_core_jackson_core",
      artifact = "com.fasterxml.jackson.core:jackson-core:2.4.5",
      sha1 = "6fb96728ee26edb19fe329d94f3bd4df1a97652a",
  )


  # org.springframework.data:spring-data-mongodb:jar:1.6.2.RELEASE got requested version
  # org.springframework.boot:spring-boot-starter-data-mongodb:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_springframework_spring_tx",
      artifact = "org.springframework:spring-tx:4.1.6.RELEASE",
      sha1 = "b5beecfa930e0e2ce6fb3999eee3f69c4776e6be",
  )


  # org.springframework.boot:spring-boot-starter:jar:1.2.3.RELEASE got requested version
  # org.springframework.boot:spring-boot-autoconfigure:jar:1.2.3.RELEASE
  native.maven_jar(
      name = "org_yaml_snakeyaml",
      artifact = "org.yaml:snakeyaml:1.14",
      sha1 = "c2df91929ed06a25001939929bff5120e0ea3fd4",
  )

  native.maven_jar(
      name = "com_google_inject_extensions_guice_servlet",
      artifact = "com.google.inject.extensions:guice-servlet:3.0",
  )

  native.maven_jar(
      name = "org_hsqldb_hsqldb",
      artifact = "org.hsqldb:hsqldb:2.4.0",
  )

  native.maven_jar(
      name = "mysql_mysql_connector_java",
      artifact = "mysql:mysql-connector-java:6.0.6",
  )

  native.maven_jar(
      name = "joda_time_joda_time",
      artifact = "joda-time:joda-time:2.9.9",
  )

  native.maven_jar(
      name = "ai_api_libai",
      artifact = "ai.api:libai:1.6.12",
  )

  native.maven_jar(
      name = "log4j_log4j",
      artifact = "log4j:log4j:1.2.17",
  )

  native.maven_jar(
      name = "com_beust_jcommander",
      artifact = "com.beust:jcommander:1.72",
  )


def generated_java_libraries():

  native.java_library(
      name = "com_beust_jcommander",
      visibility = ["//visibility:public"],
      exports = ["@com_beust_jcommander//jar"],
  )

  native.java_library(
      name = "log4j_log4j",
      visibility = ["//visibility:public"],
      exports = ["@log4j_log4j//jar"],
  )



  native.java_library(
      name = "ai_api_libai",
      visibility = ["//visibility:public"],
      exports = ["@ai_api_libai//jar"],
      runtime_deps = [
          ":com_google_code_gson_gson",
          ":org_slf4j_slf4j_api",
      ],
  )

  native.java_library(
      name = "joda_time_joda_time",
      visibility = ["//visibility:public"],
      exports = ["@joda_time_joda_time//jar"],
  )


  native.java_library(
      name = "mysql_mysql_connector_java",
      visibility = ["//visibility:public"],
      exports = ["@mysql_mysql_connector_java//jar"],
  )

  native.java_library(
      name = "org_hsqldb_hsqldb",
      visibility = ["//visibility:public"],
      exports = ["@org_hsqldb_hsqldb//jar"],
  )

  native.java_library(
      name = "asm_asm",
      visibility = ["//visibility:public"],
      exports = ["@asm_asm//jar"],
  )

  native.java_library(
      name = "org_sonatype_sisu_inject_cglib",
      visibility = ["//visibility:public"],
      exports = ["@org_sonatype_sisu_inject_cglib//jar"],
      runtime_deps = [
          ":asm_asm",
      ],
  )

  native.java_library(
      name = "com_google_inject_extensions_guice_servlet",
      visibility = ["//visibility:public"],
      exports = ["@com_google_inject_extensions_guice_servlet//jar"],
      runtime_deps = [
          ":aopalliance_aopalliance",
          ":asm_asm",
          ":com_google_inject_guice",
          ":javax_inject_javax_inject",
          ":org_sonatype_sisu_inject_cglib",
      ],
  )

  native.java_library(
      name = "ch_qos_logback_logback_classic",
      visibility = ["//visibility:public"],
      exports = ["@ch_qos_logback_logback_classic//jar"],
      runtime_deps = [
          ":ch_qos_logback_logback_core",
          ":org_slf4j_slf4j_api",
      ],
  )


  native.java_library(
      name = "org_apache_tomcat_embed_tomcat_embed_el",
      visibility = ["//visibility:public"],
      exports = ["@org_apache_tomcat_embed_tomcat_embed_el//jar"],
  )


  native.java_library(
      name = "org_springframework_spring_test",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_spring_test//jar"],
      runtime_deps = [
          ":org_springframework_spring_core",
      ],
  )


  native.java_library(
      name = "aopalliance_aopalliance",
      visibility = ["//visibility:public"],
      exports = ["@aopalliance_aopalliance//jar"],
  )


  native.java_library(
      name = "org_springframework_spring_context",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_spring_context//jar"],
      runtime_deps = [
          ":aopalliance_aopalliance",
          ":org_springframework_spring_aop",
          ":org_springframework_spring_beans",
          ":org_springframework_spring_core",
          ":org_springframework_spring_expression",
      ],
  )


  native.java_library(
      name = "org_mockito_mockito_core",
      visibility = ["//visibility:public"],
      exports = ["@org_mockito_mockito_core//jar"],
      runtime_deps = [
          ":org_hamcrest_hamcrest_core",
          ":org_objenesis_objenesis",
      ],
  )


  native.java_library(
      name = "org_springframework_spring_aop",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_spring_aop//jar"],
      runtime_deps = [
          ":aopalliance_aopalliance",
          ":org_springframework_spring_beans",
          ":org_springframework_spring_core",
      ],
  )


  native.java_library(
      name = "org_slf4j_jul_to_slf4j",
      visibility = ["//visibility:public"],
      exports = ["@org_slf4j_jul_to_slf4j//jar"],
      runtime_deps = [
          ":org_slf4j_slf4j_api",
      ],
  )


  native.java_library(
      name = "org_springframework_spring_expression",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_spring_expression//jar"],
      runtime_deps = [
          ":org_springframework_spring_core",
      ],
  )


  native.java_library(
      name = "org_slf4j_log4j_over_slf4j",
      visibility = ["//visibility:public"],
      exports = ["@org_slf4j_log4j_over_slf4j//jar"],
      runtime_deps = [
          ":org_slf4j_slf4j_api",
      ],
  )


  native.java_library(
      name = "org_jboss_logging_jboss_logging",
      visibility = ["//visibility:public"],
      exports = ["@org_jboss_logging_jboss_logging//jar"],
  )


  native.java_library(
      name = "org_springframework_boot_spring_boot_starter_logging",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_boot_spring_boot_starter_logging//jar"],
      runtime_deps = [
          ":ch_qos_logback_logback_classic",
          ":ch_qos_logback_logback_core",
          ":org_slf4j_jcl_over_slf4j",
          ":org_slf4j_jul_to_slf4j",
          ":org_slf4j_log4j_over_slf4j",
          ":org_slf4j_slf4j_api",
      ],
  )


  native.java_library(
      name = "org_hibernate_hibernate_validator",
      visibility = ["//visibility:public"],
      exports = ["@org_hibernate_hibernate_validator//jar"],
      runtime_deps = [
          ":com_fasterxml_classmate",
          ":javax_validation_validation_api",
          ":org_jboss_logging_jboss_logging",
      ],
  )


  native.java_library(
      name = "ch_qos_logback_logback_core",
      visibility = ["//visibility:public"],
      exports = ["@ch_qos_logback_logback_core//jar"],
  )


  native.java_library(
      name = "org_springframework_boot_spring_boot",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_boot_spring_boot//jar"],
      runtime_deps = [
          ":aopalliance_aopalliance",
          ":org_springframework_spring_aop",
          ":org_springframework_spring_beans",
          ":org_springframework_spring_context",
          ":org_springframework_spring_core",
          ":org_springframework_spring_expression",
      ],
  )


  native.java_library(
      name = "org_apache_tomcat_embed_tomcat_embed_logging_juli",
      visibility = ["//visibility:public"],
      exports = ["@org_apache_tomcat_embed_tomcat_embed_logging_juli//jar"],
  )


  native.java_library(
      name = "org_springframework_boot_spring_boot_starter_test",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_boot_spring_boot_starter_test//jar"],
      runtime_deps = [
          ":junit_junit",
          ":org_hamcrest_hamcrest_core",
          ":org_hamcrest_hamcrest_library",
          ":org_mockito_mockito_core",
          ":org_objenesis_objenesis",
          ":org_springframework_spring_core",
          ":org_springframework_spring_test",
      ],
  )


  native.java_library(
      name = "org_objenesis_objenesis",
      visibility = ["//visibility:public"],
      exports = ["@org_objenesis_objenesis//jar"],
  )


  native.java_library(
      name = "org_hamcrest_hamcrest_library",
      visibility = ["//visibility:public"],
      exports = ["@org_hamcrest_hamcrest_library//jar"],
      runtime_deps = [
          ":org_hamcrest_hamcrest_core",
      ],
  )


  native.java_library(
      name = "org_springframework_boot_spring_boot_starter_tomcat",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_boot_spring_boot_starter_tomcat//jar"],
      runtime_deps = [
          ":org_apache_tomcat_embed_tomcat_embed_core",
          ":org_apache_tomcat_embed_tomcat_embed_el",
          ":org_apache_tomcat_embed_tomcat_embed_logging_juli",
          ":org_apache_tomcat_embed_tomcat_embed_websocket",
      ],
  )


  native.java_library(
      name = "junit_junit",
      visibility = ["//visibility:public"],
      exports = ["@junit_junit//jar"],
      runtime_deps = [
          ":org_hamcrest_hamcrest_core",
      ],
  )


  native.java_library(
      name = "org_slf4j_slf4j_api",
      visibility = ["//visibility:public"],
      exports = ["@org_slf4j_slf4j_api//jar"],
  )


  native.java_library(
      name = "javax_validation_validation_api",
      visibility = ["//visibility:public"],
      exports = ["@javax_validation_validation_api//jar"],
  )


  native.java_library(
      name = "org_apache_tomcat_embed_tomcat_embed_core",
      visibility = ["//visibility:public"],
      exports = ["@org_apache_tomcat_embed_tomcat_embed_core//jar"],
  )


  native.java_library(
      name = "org_hamcrest_hamcrest_core",
      visibility = ["//visibility:public"],
      exports = ["@org_hamcrest_hamcrest_core//jar"],
  )


  native.java_library(
      name = "org_springframework_data_spring_data_commons",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_data_spring_data_commons//jar"],
      runtime_deps = [
          ":org_slf4j_jcl_over_slf4j",
          ":org_slf4j_slf4j_api",
          ":org_springframework_spring_beans",
          ":org_springframework_spring_core",
      ],
  )


  native.java_library(
      name = "org_springframework_boot_spring_boot_starter",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_boot_spring_boot_starter//jar"],
      runtime_deps = [
          ":aopalliance_aopalliance",
          ":ch_qos_logback_logback_classic",
          ":ch_qos_logback_logback_core",
          ":org_slf4j_jcl_over_slf4j",
          ":org_slf4j_jul_to_slf4j",
          ":org_slf4j_log4j_over_slf4j",
          ":org_slf4j_slf4j_api",
          ":org_springframework_boot_spring_boot",
          ":org_springframework_boot_spring_boot_autoconfigure",
          ":org_springframework_boot_spring_boot_starter_logging",
          ":org_springframework_spring_aop",
          ":org_springframework_spring_beans",
          ":org_springframework_spring_context",
          ":org_springframework_spring_core",
          ":org_springframework_spring_expression",
          ":org_yaml_snakeyaml",
      ],
  )


  native.java_library(
      name = "org_springframework_boot_spring_boot_starter_data_mongodb",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_boot_spring_boot_starter_data_mongodb//jar"],
      runtime_deps = [
          ":org_mongodb_mongo_java_driver",
          ":org_slf4j_jcl_over_slf4j",
          ":org_slf4j_slf4j_api",
          ":org_springframework_boot_spring_boot_starter",
          ":org_springframework_data_spring_data_commons",
          ":org_springframework_data_spring_data_mongodb",
          ":org_springframework_spring_beans",
          ":org_springframework_spring_context",
          ":org_springframework_spring_core",
          ":org_springframework_spring_expression",
          ":org_springframework_spring_tx",
      ],
  )


  native.java_library(
      name = "org_slf4j_jcl_over_slf4j",
      visibility = ["//visibility:public"],
      exports = ["@org_slf4j_jcl_over_slf4j//jar"],
      runtime_deps = [
          ":org_slf4j_slf4j_api",
      ],
  )


  native.java_library(
      name = "org_springframework_data_spring_data_mongodb",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_data_spring_data_mongodb//jar"],
      runtime_deps = [
          ":org_mongodb_mongo_java_driver",
          ":org_slf4j_jcl_over_slf4j",
          ":org_slf4j_slf4j_api",
          ":org_springframework_data_spring_data_commons",
          ":org_springframework_spring_beans",
          ":org_springframework_spring_context",
          ":org_springframework_spring_core",
          ":org_springframework_spring_expression",
          ":org_springframework_spring_tx",
      ],
  )


  native.java_library(
      name = "org_springframework_boot_spring_boot_autoconfigure",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_boot_spring_boot_autoconfigure//jar"],
      runtime_deps = [
          ":org_springframework_boot_spring_boot",
          ":org_yaml_snakeyaml",
      ],
  )


  native.java_library(
      name = "com_fasterxml_jackson_core_jackson_annotations",
      visibility = ["//visibility:public"],
      exports = ["@com_fasterxml_jackson_core_jackson_annotations//jar"],
  )


  native.java_library(
      name = "com_fasterxml_classmate",
      visibility = ["//visibility:public"],
      exports = ["@com_fasterxml_classmate//jar"],
  )


  native.java_library(
      name = "org_springframework_boot_spring_boot_starter_web",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_boot_spring_boot_starter_web//jar"],
      runtime_deps = [
          ":aopalliance_aopalliance",
          ":ch_qos_logback_logback_classic",
          ":ch_qos_logback_logback_core",
          ":com_fasterxml_classmate",
          ":com_fasterxml_jackson_core_jackson_annotations",
          ":com_fasterxml_jackson_core_jackson_core",
          ":com_fasterxml_jackson_core_jackson_databind",
          ":javax_validation_validation_api",
          ":org_apache_tomcat_embed_tomcat_embed_core",
          ":org_apache_tomcat_embed_tomcat_embed_el",
          ":org_apache_tomcat_embed_tomcat_embed_logging_juli",
          ":org_apache_tomcat_embed_tomcat_embed_websocket",
          ":org_hibernate_hibernate_validator",
          ":org_jboss_logging_jboss_logging",
          ":org_slf4j_jcl_over_slf4j",
          ":org_slf4j_jul_to_slf4j",
          ":org_slf4j_log4j_over_slf4j",
          ":org_slf4j_slf4j_api",
          ":org_springframework_boot_spring_boot",
          ":org_springframework_boot_spring_boot_autoconfigure",
          ":org_springframework_boot_spring_boot_starter",
          ":org_springframework_boot_spring_boot_starter_logging",
          ":org_springframework_boot_spring_boot_starter_tomcat",
          ":org_springframework_spring_aop",
          ":org_springframework_spring_beans",
          ":org_springframework_spring_context",
          ":org_springframework_spring_core",
          ":org_springframework_spring_expression",
          ":org_springframework_spring_web",
          ":org_springframework_spring_webmvc",
          ":org_yaml_snakeyaml",
      ],
  )


  native.java_library(
      name = "com_fasterxml_jackson_core_jackson_databind",
      visibility = ["//visibility:public"],
      exports = ["@com_fasterxml_jackson_core_jackson_databind//jar"],
      runtime_deps = [
          ":com_fasterxml_jackson_core_jackson_annotations",
          ":com_fasterxml_jackson_core_jackson_core",
      ],
  )


  native.java_library(
      name = "org_mongodb_mongo_java_driver",
      visibility = ["//visibility:public"],
      exports = ["@org_mongodb_mongo_java_driver//jar"],
  )


  native.java_library(
      name = "org_springframework_spring_web",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_spring_web//jar"],
      runtime_deps = [
          ":org_springframework_spring_aop",
          ":org_springframework_spring_beans",
          ":org_springframework_spring_context",
          ":org_springframework_spring_core",
      ],
  )


  native.java_library(
      name = "org_springframework_spring_beans",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_spring_beans//jar"],
      runtime_deps = [
          ":org_springframework_spring_core",
      ],
  )


  native.java_library(
      name = "org_apache_tomcat_embed_tomcat_embed_websocket",
      visibility = ["//visibility:public"],
      exports = ["@org_apache_tomcat_embed_tomcat_embed_websocket//jar"],
      runtime_deps = [
          ":org_apache_tomcat_embed_tomcat_embed_core",
      ],
  )


  native.java_library(
      name = "org_springframework_spring_webmvc",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_spring_webmvc//jar"],
      runtime_deps = [
          ":org_springframework_spring_beans",
          ":org_springframework_spring_context",
          ":org_springframework_spring_core",
          ":org_springframework_spring_expression",
          ":org_springframework_spring_web",
      ],
  )


  native.java_library(
      name = "org_springframework_spring_core",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_spring_core//jar"],
  )


  native.java_library(
      name = "com_fasterxml_jackson_core_jackson_core",
      visibility = ["//visibility:public"],
      exports = ["@com_fasterxml_jackson_core_jackson_core//jar"],
  )


  native.java_library(
      name = "org_springframework_spring_tx",
      visibility = ["//visibility:public"],
      exports = ["@org_springframework_spring_tx//jar"],
      runtime_deps = [
          ":org_springframework_spring_beans",
          ":org_springframework_spring_core",
      ],
  )


  native.java_library(
      name = "org_yaml_snakeyaml",
      visibility = ["//visibility:public"],
      exports = ["@org_yaml_snakeyaml//jar"],
  )

  native.java_library(
      name = "com_google_code_findbugs_jsr305",
      visibility = ["//visibility:public"],
      exports = ["@com_google_code_findbugs_jsr305//jar"],
  )


  native.java_library(
      name = "org_codehaus_mojo_animal_sniffer_annotations",
      visibility = ["//visibility:public"],
      exports = ["@org_codehaus_mojo_animal_sniffer_annotations//jar"],
  )


  native.java_library(
      name = "com_google_errorprone_error_prone_annotations",
      visibility = ["//visibility:public"],
      exports = ["@com_google_errorprone_error_prone_annotations//jar"],
  )


  native.java_library(
      name = "com_google_guava_guava",
      visibility = ["//visibility:public"],
      exports = ["@com_google_guava_guava//jar"],
      runtime_deps = [
          ":com_google_code_findbugs_jsr305",
          ":com_google_errorprone_error_prone_annotations",
          ":com_google_j2objc_j2objc_annotations",
          ":org_codehaus_mojo_animal_sniffer_annotations",
      ],
  )

  native.java_library(
      name = "com_google_j2objc_j2objc_annotations",
      visibility = ["//visibility:public"],
      exports = ["@com_google_j2objc_j2objc_annotations//jar"],
  )

  native.java_library(
      name = "com_google_inject_guice",
      visibility = ["//visibility:public"],
      exports = ["@com_google_inject_guice//jar"],
      runtime_deps = [
          ":aopalliance_aopalliance",
          ":com_google_guava_guava",
          ":javax_inject_javax_inject",
      ],
  )

  native.java_library(
      name = "javax_inject_javax_inject",
      visibility = ["//visibility:public"],
      exports = ["@javax_inject_javax_inject//jar"],
  )

  native.java_library(
      name = "io_grpc_grpc_core",
      visibility = ["//visibility:public"],
      exports = ["@io_grpc_grpc_core//jar"],
      runtime_deps = [
          ":com_google_code_findbugs_jsr305",
          ":com_google_errorprone_error_prone_annotations",
          ":com_google_guava_guava",
          ":com_google_instrumentation_instrumentation_api",
          ":io_grpc_grpc_context",
          ":io_opencensus_opencensus_api",
      ],
  )


  native.java_library(
      name = "com_google_instrumentation_instrumentation_api",
      visibility = ["//visibility:public"],
      exports = ["@com_google_instrumentation_instrumentation_api//jar"],
      runtime_deps = [
          ":com_google_code_findbugs_jsr305",
          ":com_google_errorprone_error_prone_annotations",
          ":com_google_guava_guava",
          ":io_grpc_grpc_context",
      ],
  )


  native.java_library(
      name = "io_grpc_grpc_context",
      visibility = ["//visibility:public"],
      exports = ["@io_grpc_grpc_context//jar"],
  )

  native.java_library(
      name = "io_grpc_grpc_stub",
      visibility = ["//visibility:public"],
      exports = ["@io_grpc_grpc_stub//jar"],
      runtime_deps = [
          ":com_google_code_findbugs_jsr305",
          ":com_google_errorprone_error_prone_annotations",
          ":com_google_guava_guava",
          ":com_google_instrumentation_instrumentation_api",
          ":io_grpc_grpc_context",
          ":io_grpc_grpc_core",
          ":io_opencensus_opencensus_api",
      ],
  )


  native.java_library(
      name = "io_opencensus_opencensus_api",
      visibility = ["//visibility:public"],
      exports = ["@io_opencensus_opencensus_api//jar"],
      runtime_deps = [
          ":com_google_code_findbugs_jsr305",
          ":com_google_errorprone_error_prone_annotations",
          ":com_google_guava_guava",
          ":io_grpc_grpc_context",
      ],
  )


  native.java_library(
      name = "io_grpc_grpc_protobuf_lite",
      visibility = ["//visibility:public"],
      exports = ["@io_grpc_grpc_protobuf_lite//jar"],
      runtime_deps = [
          ":com_google_guava_guava",
          ":io_grpc_grpc_core",
      ],
  )


  native.java_library(
      name = "com_google_protobuf_protobuf_java",
      visibility = ["//visibility:public"],
      exports = ["@com_google_protobuf_protobuf_java//jar"],
  )


  native.java_library(
      name = "com_google_code_gson_gson",
      visibility = ["//visibility:public"],
      exports = ["@com_google_code_gson_gson//jar"],
  )


  native.java_library(
      name = "io_grpc_grpc_protobuf",
      visibility = ["//visibility:public"],
      exports = ["@io_grpc_grpc_protobuf//jar"],
      runtime_deps = [
          ":com_google_api_grpc_proto_google_common_protos",
          ":com_google_code_findbugs_jsr305",
          ":com_google_code_gson_gson",
          ":com_google_errorprone_error_prone_annotations",
          ":com_google_guava_guava",
          ":com_google_instrumentation_instrumentation_api",
          ":com_google_protobuf_protobuf_java",
          ":com_google_protobuf_protobuf_java_util",
          ":io_grpc_grpc_context",
          ":io_grpc_grpc_core",
          ":io_grpc_grpc_protobuf_lite",
          ":io_opencensus_opencensus_api",
      ],
  )

  native.java_library(
      name = "com_google_protobuf_protobuf_java_util",
      visibility = ["//visibility:public"],
      exports = ["@com_google_protobuf_protobuf_java_util//jar"],
      runtime_deps = [
          ":com_google_code_gson_gson",
          ":com_google_guava_guava",
          ":com_google_protobuf_protobuf_java",
      ],
  )


  native.java_library(
      name = "com_google_api_grpc_proto_google_common_protos",
      visibility = ["//visibility:public"],
      exports = ["@com_google_api_grpc_proto_google_common_protos//jar"],
      runtime_deps = [
          ":com_google_protobuf_protobuf_java",
      ],
  )

  native.java_library(
      name = "io_grpc_grpc_core",
      visibility = ["//visibility:public"],
      exports = ["@io_grpc_grpc_core//jar"],
      runtime_deps = [
          ":com_google_code_findbugs_jsr305",
          ":com_google_errorprone_error_prone_annotations",
          ":com_google_guava_guava",
          ":com_google_instrumentation_instrumentation_api",
          ":io_grpc_grpc_context",
          ":io_opencensus_opencensus_api",
      ],
  )


  native.java_library(
      name = "org_mybatis_mybatis",
      visibility = ["//visibility:public"],
      exports = ["@org_mybatis_mybatis//jar"],
  )

  native.java_library(
      name = "org_mybatis_mybatis_guice",
      visibility = ["//visibility:public"],
      exports = ["@org_mybatis_mybatis_guice//jar"],
  )