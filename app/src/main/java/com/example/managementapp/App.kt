package com.example.managementapp

import android.app.Application
import com.example.managementapp.data.storage.user.UserRepositoryImpl

object App {

    val userRepository = UserRepositoryImpl()
}