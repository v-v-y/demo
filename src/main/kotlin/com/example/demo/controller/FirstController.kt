package com.example.demo.controller

import com.example.demo.service.GoogleService
import org.slf4j.MDC
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("v1")
class FirstController(
    private val googleService: GoogleService
) {

    @GetMapping("discovery")
    fun getDiscovery(): String {
        MDC.put("trace_id", UUID.randomUUID().toString())
        return googleService.google()
    }
}