package io.fabric8.launcher.creator.catalog.generators

import io.fabric8.launcher.creator.core.catalog.GeneratorConstructor
import io.fabric8.launcher.creator.core.catalog.readGeneratorInfoDef

enum class GeneratorInfo(val klazz: GeneratorConstructor) {
    `database-crud-dotnet`(::DatabaseCrudDotnet),
    `database-crud-nodejs`(::DatabaseCrudNodejs),
    `database-crud-quarkus`(::DatabaseCrudQuarkus),
    `database-crud-springboot`(::DatabaseCrudSpringboot),
    `database-crud-thorntail`(::DatabaseCrudThorntail),
    `database-crud-vertx`(::DatabaseCrudVertx),
    `database-crud-wildfly`(::DatabaseCrudWildfly),
    `database-mysql`(::DatabaseMysql),
    `database-postgresql`(::DatabasePostgresql),
    `database-secret`(::DatabaseSecret),
    `import-codebase`(::ImportCodebase),
    `language-csharp`(::LanguageCsharp),
    `language-java`(::LanguageJava),
    `language-nodejs`(::LanguageNodejs),
    `maven-setup`(::MavenSetup),
    `platform-angular`(::PlatformAngular),
    `platform-base-support`(::PlatformBaseSupport),
    `platform-dotnet`(::PlatformDotnet),
    `platform-nodejs`(::PlatformNodejs),
    `platform-quarkus`(::PlatformQuarkus),
    `platform-react`(::PlatformReact),
    `platform-springboot`(::PlatformSpringboot),
    `platform-thorntail`(::PlatformThorntail),
    `platform-vertx`(::PlatformVertx),
    `platform-vuejs`(::PlatformVuejs),
    `platform-wildfly`(::PlatformWildfly),
    `rest-dotnet`(::RestDotnet),
    `rest-nodejs`(::RestNodejs),
    `rest-quarkus`(::RestQuarkus),
    `rest-springboot`(::RestSpringboot),
    `rest-thorntail`(::RestThorntail),
    `rest-vertx`(::RestVertx),
    `rest-wildfly`(::RestWildfly),
    `welcome-app`(::WelcomeApp);

    val info by lazy { readGeneratorInfoDef(this.name) }
}