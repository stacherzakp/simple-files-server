package com.staszkox.files.server

import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import java.net.URLConnection
import java.nio.file.Path
import java.nio.file.Paths

@Service
class FilesService(private final val filesConfigurationProperties: FilesConfigurationProperties) {

    private final val uploadDir: Path = Paths.get(filesConfigurationProperties.uploadDir)
            .toAbsolutePath().normalize()

    fun getFile(id: String): ResourceDescriptor {

        val filePath = uploadDir.resolve("test.txt").normalize()
        val contentType = URLConnection.guessContentTypeFromName("test.txt")

        return ResourceDescriptor(UrlResource(filePath.toUri()), "test.txt", contentType)
    }

    fun getConfiguration(): FilesConfigurationProperties {
        return filesConfigurationProperties
    }
}

data class ResourceDescriptor(val resource: Resource, val fileName: String, val contentType: String)