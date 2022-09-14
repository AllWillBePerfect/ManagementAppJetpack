package com.example.managementapp.domain.repositories

interface UserRepository {

    fun setUser(email: String, password: String)

    fun removeUser()

    fun isSigned(): Boolean
}