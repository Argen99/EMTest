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
include(":feature-auth")
include(":feature-main")
include(":feature-main:main-presentation")
include(":feature-main:main-domain")
include(":feature-favorites")
include(":feature-favorites:favorites-presentation")
include(":feature-favorites:favorites-domain")
include(":feature-account")
include(":feature-account:account-presentation")
include(":feature-account:account-domain")
include(":feature-auth:presentation")
include(":feature-auth:domain")
