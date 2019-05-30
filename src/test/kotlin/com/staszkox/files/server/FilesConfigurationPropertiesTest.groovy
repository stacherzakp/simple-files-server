package com.staszkox.files.server

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

class FilesConfigurationPropertiesTest extends Specification {

    def "uploadDir property should be ignored in json"() {

        given:
            def properties = new FilesConfigurationProperties()
            properties.uploadDir = "C://secret"
            properties.allowedExtensions = ["jpg", "png"]
        when:
            def jsonMapper = new ObjectMapper()
            def propertiesAsJson = jsonMapper.writeValueAsString(properties)
        then:
            !propertiesAsJson.contains("secret")
            propertiesAsJson.contains("jpg")
            propertiesAsJson.contains("png")
    }
}
