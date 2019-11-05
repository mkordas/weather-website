plugins {
    java
    groovy
    id("org.springframework.boot") version "2.2.0.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

repositories {
    jcenter()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.spockframework:spock-core:1.3-groovy-2.5")
    testImplementation("org.codehaus.groovy:groovy-all:2.5.8")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}