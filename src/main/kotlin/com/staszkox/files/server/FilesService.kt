package com.staszkox.files.server

import org.springframework.stereotype.Service
import java.io.File
import java.util.*

@Service
class FilesService(val filesConfiguration: FilesConfiguration) {

    fun getFile(id: String): File? {
        return null
    }

    fun saveFile(file: File): FileDescriptor {
        return FileDescriptor(id = UUID.randomUUID().toString(), fileName = "", size = 123)
    }

    fun updateFile(newFile: File, id: String): FileDescriptor {
        return FileDescriptor("", "", 123)
    }

    fun getConfiguration(): FilesConfiguration {
        return filesConfiguration
    }
}

data class FileDescriptor(val id: String = "", val fileName: String, val size: Long)