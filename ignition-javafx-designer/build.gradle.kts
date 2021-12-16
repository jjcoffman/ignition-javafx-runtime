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
    api(projects.ignitionJavafxClient)
    implementation("com.inductiveautomation.ignitionsdk:designer-api:8.1.12")
    implementation("com.inductiveautomation.ignitionsdk:vision-designer-api:8.1.12")
}
