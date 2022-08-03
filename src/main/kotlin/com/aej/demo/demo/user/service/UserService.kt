package com.aej.demo.demo.user.service

import com.aej.demo.demo.User

interface UserService {
    fun getUserByName(name: String): User?
    fun getUser(): List<User>
    fun addUser(user: User): List<User>
    fun getIds(): List<String>
}