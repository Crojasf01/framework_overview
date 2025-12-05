package org.example

data class UserData(
    val id: Int,
    val email: String,
    val first_name: String
)

data class UserResponse(
    val data: UserData
)

data class LoginRequest(val email: String, val password: String)

data class LoginResponse(val token: String?)
