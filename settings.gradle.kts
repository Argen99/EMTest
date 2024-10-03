pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EMTest"
include(":app")
include(":core")
include(":core-ui")
include(":data")
include(":features")
include(":features:search")
include(":features:search:domain")
include(":features:search:presentation")
include(":features:favorites")
include(":features:favorites:presentation")
include(":features:responses")
include(":features:responses:presentation")
include(":features:messages")
include(":features:messages:presentation")
include(":features:profile")
include(":features:profile:presentation")
include(":features:favorites:domain")
