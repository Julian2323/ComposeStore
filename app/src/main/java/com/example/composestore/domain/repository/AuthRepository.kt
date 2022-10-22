package com.example.composestore.domain.repository

import com.example.composestore.common.Resource
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun login(email: String, password: String): Resource<FirebaseUser>

    suspend fun signup(name: String, email: String, password: String): Resource<FirebaseUser>

    fun logout()
}