package com.example.demo.service

import com.example.demo.GoogleClient
import org.springframework.stereotype.Service

@Service
class GoogleService(private val googleClient: GoogleClient) {

    fun google(): String {
        return googleClient.discovery("v1")
    }
}