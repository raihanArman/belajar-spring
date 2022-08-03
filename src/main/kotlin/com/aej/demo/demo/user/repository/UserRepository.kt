package com.aej.demo.demo.user.repository

import com.aej.demo.demo.User

interface UserRepository {
    fun getUserByName(name: String): User?
    fun getUsers(): List<User>
    fun addUser(name: String): List<User>
}