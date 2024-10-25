package com.example.dc.Controller

import com.example.dc.Entity.UserTable
import com.example.dc.Service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController (@Autowired
                      var userService: UserService
){

    @PostMapping()
fun addUser(@RequestBody user: UserTable):ResponseEntity<*>{

val responseEntity:ResponseEntity<*> = ResponseEntity.ok(userService.addUser(user))
        return responseEntity
}
    @GetMapping("/{id}")
    fun printMessage(@PathVariable id:Long): ResponseEntity<*>{

        val responseEntity:ResponseEntity<*> = ResponseEntity.ok(userService.findUser(id))
        return responseEntity
    }
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id:Long,@RequestBody user: UserTable): ResponseEntity<*> {
        val response : ResponseEntity<*> = ResponseEntity.ok(userService.updateUser(id,user))
        return  response
    }
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id:Long):ResponseEntity<*> {
        val response: ResponseEntity<*> = ResponseEntity.ok(userService.delete(id))
        return response
    }
    @GetMapping()
    fun users():ResponseEntity<*>{
        val response: ResponseEntity<*> = ResponseEntity.ok(userService.getAllUser())
        return response
    }
}