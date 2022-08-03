package com.aej.demo.demo

import com.aej.demo.demo.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

data class User(
        var id: String = UUID.randomUUID().toString(),
        var name: String = ""
)

@RestController
@RequestMapping("/v1/user")
class UserController {

    @Autowired
    private lateinit var service: UserService

    @GetMapping
    fun getUser(): BaseResponse<List<User>>{
        return BaseResponse(
                status = true,
                message = "Berhasil get data",
                data = service.getUser()
        )
    }

    @PostMapping
    fun addUser(
            @RequestBody user: User
    ): List<User>{
        return service.addUser(user)
    }

    @GetMapping("/{id}")
    fun getUserByName(
            @PathVariable(value = "name") name: String
    ): User? {
        return service.getUserByName(name)
    }

}