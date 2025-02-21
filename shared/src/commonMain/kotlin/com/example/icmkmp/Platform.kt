package com.example.icmkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform