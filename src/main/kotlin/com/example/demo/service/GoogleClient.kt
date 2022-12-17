package com.example.demo

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "Google",
    url = "https://docs.googleapis.com",
    configuration = [GoogleClientConfiguration::class]
)
interface GoogleClient {

    @GetMapping("/\$discovery/rest")
    fun discovery(@RequestParam("version") version: String): String

}