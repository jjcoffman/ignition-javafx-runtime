// add resources to the test sources so gui tests dependent on graphics will resolve

plugins {
    `java-library`
    checkstyle
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    implementation("com.inductiveautomation.ignitionsdk:ignition-common:8.1.12")
    implementation("com.inductiveautomation.ignitionsdk:client-api:8.1.12")
    implementation("com.inductiveautomation.ignitionsdk:vision-client-api:8.1.12")
}
