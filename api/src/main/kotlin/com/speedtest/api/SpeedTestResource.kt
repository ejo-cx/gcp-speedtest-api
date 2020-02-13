package com.speedtest.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate
import com.google.gson.Gson


@RestController
@RequestMapping("/speedtest")
class SpeedTestResource() {

    val gson: Gson = Gson()

    data class Server(val host: String, val lat: Float, val lon: Float, val country: String, val distance: Int, val ping: Int, val id: Int)
    data class Client(val ip: String, val lat: Float, val lon: Float, val isp: String, val country: String)
    data class Speeds(val download: Float, val upload: Float)
    data class Data(val speeds: Speeds, val client: Client, val server: Server)
    data class TestResult(val user: String, val device: Int, val timestamp: Long, val data: Data)

    
    @PostMapping
    fun createUser(@RequestBody testResult: TestResult) {
        println(testResult.user)
    }

}
