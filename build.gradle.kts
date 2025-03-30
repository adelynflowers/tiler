plugins {
  kotlin("jvm") version "2.1.10"
  id("com.ncorti.ktfmt.gradle") version "0.22.0"
  jacoco
}

allprojects { plugins.apply("com.ncorti.ktfmt.gradle") }

subprojects {
  apply(plugin = "kotlin")
  apply(plugin = "jacoco")
  jacoco { toolVersion = "0.8.12" }
  group = "io.github.adelynflowers"
  version = "1.0-SNAPSHOT"

  repositories { mavenCentral() }

  kotlin { jvmToolchain(23) }

  tasks.withType<JacocoCoverageVerification> {
    violationRules {
      rule {
        limit {
          minimum = "0.9".toBigDecimal()
          counter = "INSTRUCTION"
        }
        limit {
          minimum = "1.0".toBigDecimal()
          counter = "BRANCH"
        }
      }
    }
  }

  tasks.named("check") { dependsOn("jacocoTestCoverageVerification") }
  tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
  }

  tasks.withType<JacocoReport> {
    dependsOn(tasks.test)
    reports {
      html.required.set(true)
      xml.required.set(true)
    }
  }
}

repositories { mavenCentral() }
