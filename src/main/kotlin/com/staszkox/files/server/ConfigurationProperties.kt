package com.staszkox.files.server

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "files")
class FilesConfigurationProperties {

    @JsonIgnore
    lateinit var uploadDir: String

    lateinit var allowedExtensions: Array<String>
}

