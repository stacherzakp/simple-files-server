package com.staszkox.files.server

import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FilesController(val filesService: FilesService) {

    @GetMapping(
            value = ["/files/{id}"]
    )
    fun getFile(@PathVariable id: String): ResponseEntity<Resource> {

        val file = filesService.getFile(id)

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.fileName + "\"")
                .body(file.resource)
    }

    @GetMapping(
            value = ["/configuration"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getConfiguration(): Any {
        return filesService.getConfiguration()
    }
}