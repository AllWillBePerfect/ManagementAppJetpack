package com.example.managementapp.data.storage.user

import com.example.managementapp.domain.entities.User
import com.example.managementapp.domain.repositories.UserRepository

class UserRepositoryImpl: UserRepository {

    private var user: User? = null

    override fun setUser(email: String, password: String) {
        user = User(email, password)
    }

    override fun removeUser() {
        user = null
    }

    override fun isSigned(): Boolean {
        return user != null
    }
}