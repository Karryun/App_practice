package com.example.log_inout

data class User(
    var name: String,
    var email: String,
    val password: String
){
    constructor(): this("","","")
}
