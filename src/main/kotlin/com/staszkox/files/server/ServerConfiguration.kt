package com.staszkox.files.server

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "files")
class FilesConfiguration {

    val upload = UploadConfiguration()
    val download = DownloadConfiguration()

    class UploadConfiguration {
        lateinit var maxSize: String
        lateinit var allowedExtensions: Array<String>
    }

    class DownloadConfiguration {
        lateinit var contentType: String
    }
}

