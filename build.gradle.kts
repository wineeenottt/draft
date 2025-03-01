plugins {
    id("java")
    application
}

group = "org.wineeenottt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Здесь могут быть зависимости, если они нужны
}

application {
    mainClass.set("org.wineeenottt.Run.Main")  // Указываем основной класс в пакете Run
}


tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.wineeenottt.Run.Main"

    }
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
