warning: LF will be replaced by CRLF in pom.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in src/main/java/com/example/demo/DemoApplication.java.
The file will have its original line endings in your working directory.
[1mdiff --git a/pom.xml b/pom.xml[m
[1mindex c616619..79a665d 100644[m
[1m--- a/pom.xml[m
[1m+++ b/pom.xml[m
[36m@@ -6,15 +6,17 @@[m
 	<groupId>com.example</groupId>[m
 	<artifactId>SpringControllerAdviceDemo</artifactId>[m
 	<version>0.0.1-SNAPSHOT</version>[m
[31m-	<packaging>war</packaging>[m
[32m+[m	[32m<packaging>jar</packaging>[m
 [m
 	<name>SpringControllerAdviceDemo</name>[m
 	<description>Demo project for Spring Boot</description>[m
 [m
[32m+[m
 	<parent>[m
 		<groupId>org.springframework.boot</groupId>[m
 		<artifactId>spring-boot-starter-parent</artifactId>[m
[31m-		<version>2.0.0.M4</version>[m
[32m+[m		[32m<!-- <version>2.0.0.M4</version> -->[m
[32m+[m		[32m<version>1.5.4.RELEASE</version>[m
 		<relativePath /> <!-- lookup parent from repository -->[m
 	</parent>[m
 [m
[36m@@ -22,6 +24,7 @@[m
 		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>[m
 		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>[m
 		<java.version>1.8</java.version>[m
[32m+[m		[32m<camel.version>2.19.0</camel.version>[m
 	</properties>[m
 [m
 	<dependencies>[m
[36m@@ -40,6 +43,33 @@[m
 			<groupId>org.springframework.boot</groupId>[m
 			<artifactId>spring-boot-devtools</artifactId>[m
 		</dependency>[m
[32m+[m
[32m+[m		[32m<!-- CAMEL DEPENDENCIES -->[m
[32m+[m		[32m<dependency>[m
[32m+[m			[32m<groupId>org.apache.camel</groupId>[m
[32m+[m			[32m<artifactId>camel-servlet-starter</artifactId>[m
[32m+[m			[32m<version>${camel.version}</version>[m
[32m+[m		[32m</dependency>[m
[32m+[m		[32m<dependency>[m
[32m+[m			[32m<groupId>org.apache.camel</groupId>[m
[32m+[m			[32m<artifactId>camel-jackson-starter</artifactId>[m
[32m+[m			[32m<version>${camel.version}</version>[m
[32m+[m		[32m</dependency>[m
[32m+[m		[32m<dependency>[m
[32m+[m			[32m<groupId>org.apache.camel</groupId>[m
[32m+[m			[32m<artifactId>camel-swagger-java-starter</artifactId>[m
[32m+[m			[32m<version>${camel.version}</version>[m
[32m+[m		[32m</dependency>[m
[32m+[m		[32m<dependency>[m
[32m+[m			[32m<groupId>org.apache.camel</groupId>[m
[32m+[m			[32m<artifactId>camel-spring-boot-starter</artifactId>[m
[32m+[m			[32m<version>${camel.version}</version>[m
[32m+[m		[32m</dependency>[m
[32m+[m		[32m<dependency>[m
[32m+[m			[32m<groupId>org.apache.camel</groupId>[m
[32m+[m			[32m<artifactId>camel-jaxb-starter</artifactId>[m
[32m+[m			[32m<version>${camel.version}</version>[m
[32m+[m		[32m</dependency>[m
 	</dependencies>[m
 [m
 	<build>[m
[36m@@ -47,6 +77,13 @@[m
 			<plugin>[m
 				<groupId>org.springframework.boot</groupId>[m
 				<artifactId>spring-boot-maven-plugin</artifactId>[m
[32m+[m				[32m<executions>[m
[32m+[m					[32m<execution>[m
[32m+[m						[32m<goals>[m
[32m+[m							[32m<goal>repackage</goal>[m
[32m+[m						[32m</goals>[m
[32m+[m					[32m</execution>[m
[32m+[m				[32m</executions>[m
 				<configuration>[m
 					<jvmArguments>[m
 						-Xdebug[m
[36m@@ -54,6 +91,10 @@[m
 					</jvmArguments>[m
 				</configuration>[m
 			</plugin>[m
[32m+[m			[32m<plugin>[m
[32m+[m				[32m<groupId>org.apache.maven.plugins</groupId>[m
[32m+[m				[32m<artifactId>maven-surefire-plugin</artifactId>[m
[32m+[m			[32m</plugin>[m
 		</plugins>[m
 	</build>[m
 [m
[36m@@ -94,6 +135,4 @@[m
 			</snapshots>[m
 		</pluginRepository>[m
 	</pluginRepositories>[m
[31m-[m
[31m-[m
 </project>[m
[1mdiff --git a/src/main/java/com/example/demo/DemoApplication.java b/src/main/java/com/example/demo/DemoApplication.java[m
[1mindex 7eaddf4..7bff334 100644[m
[1m--- a/src/main/java/com/example/demo/DemoApplication.java[m
[1m+++ b/src/main/java/com/example/demo/DemoApplication.java[m
[36m@@ -1,12 +1,29 @@[m
 package com.example.demo;[m
 [m
[32m+[m[32mimport org.apache.camel.component.servlet.CamelHttpTransportServlet;[m
[32m+[m[32mimport org.springframework.beans.factory.annotation.Value;[m
 import org.springframework.boot.SpringApplication;[m
 import org.springframework.boot.autoconfigure.SpringBootApplication;[m
[32m+[m[32mimport org.springframework.boot.web.servlet.ServletRegistrationBean;[m
[32m+[m[32mimport org.springframework.context.annotation.Bean;[m
[32m+[m[32mimport org.springframework.context.annotation.ComponentScan;[m
 [m
 @SpringBootApplication[m
[32m+[m[32m@ComponentScan(basePackages="com.example.demo")[m
 public class DemoApplication {[m
 [m
 	public static void main(String[] args) {[m
 		SpringApplication.run(DemoApplication.class, args);[m
 	}[m
[32m+[m[41m	[m
[32m+[m	[32m@Value("${payX.api.path}")[m
[32m+[m	[32mString contextPath;[m
[32m+[m[41m	 [m
[32m+[m	[32m@Bean[m
[32m+[m	[32mServletRegistrationBean servletRegistrationBean() {[m
[32m+[m	[32m    ServletRegistrationBean servlet = new ServletRegistrationBean[m
[32m+[m	[32m      (new CamelHttpTransportServlet(), contextPath+"/*");[m
[32m+[m	[32m    servlet.setName("CamelServlet");[m
[32m+[m	[32m    return servlet;[m
[32m+[m	[32m}[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/src/main/java/com/example/demo/controller/ExampleController.java b/src/main/java/com/example/demo/controller/ExampleController.java[m
[1mindex f1289b2..ba9710f 100644[m
[1m--- a/src/main/java/com/example/demo/controller/ExampleController.java[m
[1m+++ b/src/main/java/com/example/demo/controller/ExampleController.java[m
[36m@@ -35,6 +35,7 @@[m [mpublic class ExampleController {[m
 	 * @return an exception[m
 	 * @throws Exception[m
 	 */[m
[32m+[m	[32m@SuppressWarnings("null")[m
 	@GetMapping(value = "/nullExceptionHandler/")[m
 	public String nullTest() throws Exception {[m
 		System.out.println("Unexpected situation!");[m
[1mdiff --git a/src/main/java/com/example/demo/exception/ExampleCustomNPE.java b/src/main/java/com/example/demo/exception/ExampleCustomNPE.java[m
[1mindex 777b80a..eadd9cc 100644[m
[1m--- a/src/main/java/com/example/demo/exception/ExampleCustomNPE.java[m
[1m+++ b/src/main/java/com/example/demo/exception/ExampleCustomNPE.java[m
[36m@@ -23,4 +23,4 @@[m [mpublic class ExampleCustomNPE extends CustomException {[m
 		this.code = code;[m
 		this.message = message;[m
 	}[m
[31m-}[m
[32m+[m[32m}[m
\ No newline at end of file[m
[1mdiff --git a/src/main/resources/application.properties b/src/main/resources/application.properties[m
[1mindex 34b0d8e..a17a1f5 100644[m
[1m--- a/src/main/resources/application.properties[m
[1m+++ b/src/main/resources/application.properties[m
[36m@@ -1,3 +1,12 @@[m
 spring.mvc.view.prefix = /[m
 spring.mvc.view.suffix = .html[m
[31m-spring.mvc.static-path-pattern=/resources/**[m
\ No newline at end of file[m
[32m+[m[32mspring.mvc.static-path-pattern=/resources/**[m
[32m+[m
[32m+[m
[32m+[m[32mlogging.config=classpath:logback.xml[m
[32m+[m[32mcamel.springboot.name=payX[m
[32m+[m[32mserver.address=0.0.0.0[m
[32m+[m[32mmanagement.address=0.0.0.0[m
[32m+[m[32mmanagement.port=8081[m
[32m+[m[32mendpoints.enabled = true[m
[32m+[m[32mendpoints.health.enabled = true[m
\ No newline at end of file[m
