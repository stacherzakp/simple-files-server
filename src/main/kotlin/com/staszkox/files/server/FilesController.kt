package com.staszkox.files.server

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FilesController(val filesService: FilesService) {

    @GetMapping(
            value = ["/files/{id}"],
            produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    fun getFile(@PathVariable id: String): Any {
        print("asd");
        return "World $id"
    }

    @GetMapping(
            value = ["/configuration"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getConfiguration(): Any {
        return filesService.getConfiguration()
    }
}