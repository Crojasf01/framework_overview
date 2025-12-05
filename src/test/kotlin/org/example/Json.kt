package org.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

val objectMapper: ObjectMapper =
    jacksonObjectMapper().apply {
        registerKotlinModule()
    }
