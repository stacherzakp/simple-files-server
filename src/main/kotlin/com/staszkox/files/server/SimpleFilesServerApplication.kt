package com.staszkox.files.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class, DataSourceTransactionManagerAutoConfiguration::class])
@EnableConfigurationProperties(FilesConfigurationProperties::class)
class SimpleFilesServerApplication

fun main(args: Array<String>) {
    runApplication<SimpleFilesServerApplication>(*args)
}
